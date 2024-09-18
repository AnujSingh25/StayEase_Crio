package com.crio.stayease.services;

import com.crio.stayease.exchanges.LoginUserRequest;
import com.crio.stayease.exchanges.LoginUserResponse;
import com.crio.stayease.exchanges.RegisterUserRequest;
import com.crio.stayease.exchanges.RegisterUserResponse;

public interface UserService {
    
    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);

    LoginUserResponse loginUser(LoginUserRequest loginUserRequest);
}
