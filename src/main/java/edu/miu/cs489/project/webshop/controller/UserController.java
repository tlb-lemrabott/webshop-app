package edu.miu.cs489.project.webshop.controller;

import edu.miu.cs489.project.webshop.dto.UserAuthRequest;
import edu.miu.cs489.project.webshop.dto.UserAuthResponse;
import edu.miu.cs489.project.webshop.dto.UserSignUpRequest;
import edu.miu.cs489.project.webshop.model.User;
import edu.miu.cs489.project.webshop.security.util.JWTMgmtUtilityService;
import edu.miu.cs489.project.webshop.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping(path = "/webshop/api/v1/auth")
public class UserController {
    private JWTMgmtUtilityService jwtMgmtUtilityService;
    private AuthenticationManager authenticationManager;
    private UserService userService;

    public UserController(
            JWTMgmtUtilityService jwtMgmtUtilityService,
            AuthenticationManager authenticationManager,
            UserService userService
    ) {
        this.jwtMgmtUtilityService = jwtMgmtUtilityService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<UserAuthResponse> authenticateUser(@Valid @RequestBody UserAuthRequest userAuthRequest) throws Exception {
        UserAuthResponse userAuthResponse = null;
        try {
            var username = userAuthRequest.username();
            var password = userAuthRequest.password();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            var jwtToken = jwtMgmtUtilityService.generateToken(username);
            var user = userService.getUserByUsername(username);
            if(user != null) {
                userAuthResponse = new UserAuthResponse(jwtToken, user.getRole());
            }
        } catch (Exception ex) {
            System.out.println("UserAuthException is: " + ex);
            throw ex;
        }
        return ResponseEntity.ok(userAuthResponse);
    }
    @PostMapping(path = "/register")
    public ResponseEntity<User> authenticateUser(@Valid @RequestBody User user) {
        try {
            System.out.println("register is called !");
            User registeredUser = this.userService.registerNewUser(user);
            return ResponseEntity.ok(registeredUser);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }





}
