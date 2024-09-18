package com.crio.stayease.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.crio.stayease.dto.UserDto;
import com.crio.stayease.exchanges.LoginUserRequest;
import com.crio.stayease.exchanges.LoginUserResponse;
import com.crio.stayease.exchanges.RegisterUserRequest;
import com.crio.stayease.exchanges.RegisterUserResponse;
import com.crio.stayease.services.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testRegisterUser() throws Exception {
        String requestBody = "{\"firstName\": \"Anuj\",\"lastName\": \"Singh\",\"email\": \"anujsingh@gmail.com\",\"password\": \"1234\",\"role\": \"CUSTOMER\"}";

        UserDto user = new UserDto();
        user.setId(1);
        user.setFirstName("Anuj");
        user.setLastName("Singh");
        user.setEmail("anujsingh@gmail.com");
        user.setPassword("1234");
        user.setRole("CUSTOMER");
        user.setBookings(new HashSet<>());

        String jwtToken = "INPUT_YOUR_256_BIT_SECRET_KEY";
        RegisterUserResponse registerUserResponse = new RegisterUserResponse(user, jwtToken);

        when(userService.registerUser(any(RegisterUserRequest.class))).thenReturn(registerUserResponse);

        mockMvc.perform(post("/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userDto.id").value(1))
                .andExpect(jsonPath("$.userDto.firstName").value("Anuj"))
                .andExpect(jsonPath("$.userDto.lastName").value("Singh"))
                .andExpect(jsonPath("$.userDto.email").value("anujsingh@gmail.com"))
                .andExpect(jsonPath("$.userDto.password").value("1234"))
                .andExpect(jsonPath("$.userDto.role").value("CUSTOMER"));

        verify(userService, times(1)).registerUser(any(RegisterUserRequest.class));
    }

    @Test
    public void testLoginUser() throws Exception {
        String requestBody = "{\"email\": \"anujsingh@gmail.com\",\"password\": \"1234\"}";
        String jwtToken = "INPUT_YOUR_256_BIT_SECRET_KEY";
        LoginUserResponse loginUserResponse = new LoginUserResponse(jwtToken);

        when(userService.loginUser(any(LoginUserRequest.class))).thenReturn(loginUserResponse);

        mockMvc.perform(post("/users/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.jwtToken").value(loginUserResponse.getJwtToken()));

        verify(userService, times(1)).loginUser(any(LoginUserRequest.class));
    }
}
