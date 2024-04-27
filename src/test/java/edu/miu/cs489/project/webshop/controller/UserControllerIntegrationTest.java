package edu.miu.cs489.project.webshop.controller;

import edu.miu.cs489.project.webshop.enums.RoleEnum;
import edu.miu.cs489.project.webshop.model.User;
import edu.miu.cs489.project.webshop.service.util.JWTMgmtUtilityService;
import edu.miu.cs489.project.webshop.service.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class UserControllerIntegrationTest {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTMgmtUtilityService jwtMgmtUtilityService;
    //@Autowired
    private MockMvc mockMvc;
    private final String TEST_USERNAME = "admin";
    private final String TEST_PASSWORD = "admin@admin";
    private final RoleEnum TEST_ROLE = RoleEnum.ADMIN;

    private String testToken;
    @BeforeEach
    void setUp() {
        User testUser = new User();
        testUser.setUsername(TEST_USERNAME);
        testUser.setPassword(TEST_PASSWORD);
        testUser.setRole(TEST_ROLE);
        userService.registerNewUser(testUser);
        // Generate token for authentication
        testToken = jwtMgmtUtilityService.generateToken(TEST_USERNAME);
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    void authenticateUser() throws Exception{
//        UserAuthRequest authRequest = new UserAuthRequest(TEST_USERNAME, TEST_PASSWORD);
//        String requestJson = "{ \"username\": \"" + TEST_USERNAME + "\", \"password\": \"" + TEST_PASSWORD + "\" }";
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/webshop/api/v1/auth/login")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestJson))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.jwtToken").exists())
//                .andExpect(jsonPath("$.role").exists())
//                .andReturn();
//
//        String responseContent = result.getResponse().getContentAsString();
    }

    @Test
    void registerNewUser() {
    }


}