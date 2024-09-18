package com.crio.stayease.exchanges;

import com.crio.stayease.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterUserResponse {

    private UserDto userDto;

    private String jwtToken;
    
}
