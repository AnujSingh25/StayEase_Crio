package com.crio.stayease.repositoryServices;

import com.crio.stayease.dto.UserDto;
import com.crio.stayease.entities.enums.Role;

public interface UserRepositoryService {

    UserDto registerUser(String firstName, String lastName, String email, String password, Role role);

    UserDto findUserByEmail(String email);
}
