package edu.miu.cs489.project.webshop.controller;

import edu.miu.cs489.project.webshop.dto.UserAuthRequest;
import edu.miu.cs489.project.webshop.dto.UserAuthResponse;
import edu.miu.cs489.project.webshop.enums.RoleEnum;
import edu.miu.cs489.project.webshop.model.User;
import edu.miu.cs489.project.webshop.service.util.JWTMgmtUtilityService;
import edu.miu.cs489.project.webshop.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProductController.class)
@AutoConfigureMockMvc
class UserControllerUnitTest {
    @InjectMocks
    private UserController userController;
    @MockBean
    private UserService userService;
    @Mock
    private JWTMgmtUtilityService jwtMgmtUtilityService;
    @Mock
    private AuthenticationManager authenticationManager;

    private final String TEST_USERNAME = "admin";
    private final String TEST_PASSWORD = "admin@admin";
    private final RoleEnum TEST_ROLE = RoleEnum.ADMIN;
    private final String TEST_TOKEN = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTcxNDEwNDk3MSwiZXhwIjoxNzE0MTkxMzcxfQ.aEOXehso699sSJxSoJWhrSGrJby-CCVnAyyv_TYeveCiKeikiqIw2afbxjNEgAHR";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void authenticateUser_Success() throws Exception {
        UserAuthRequest request = new UserAuthRequest(TEST_USERNAME, TEST_PASSWORD);
        User user = new User();
        user.setUsername(TEST_USERNAME);
        user.setRole(TEST_ROLE);
        when(userService.getUserByUsername(TEST_USERNAME)).thenReturn(user);
        when(jwtMgmtUtilityService.generateToken(TEST_USERNAME)).thenReturn(TEST_TOKEN);
        ResponseEntity<UserAuthResponse> responseEntity = userController.authenticateUser(request);
        // Verification
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("mockedToken", responseEntity.getBody().jwtToken());
        assertEquals(RoleEnum.ADMIN, responseEntity.getBody().role());
    }

    @Test
    void registerNewUser_Success() {
        User newUser = new User();
        newUser.setUsername("newUser");
        newUser.setPassword("password");
        when(userService.registerNewUser(any(User.class))).thenReturn(newUser);
        ResponseEntity<User> responseEntity = userController.registerNewUser(newUser);
        // Verification
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("newUser", responseEntity.getBody().getUsername());
    }


}