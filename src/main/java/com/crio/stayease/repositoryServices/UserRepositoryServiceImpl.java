package com.crio.stayease.repositoryServices;

import org.springframework.stereotype.Service;

import com.crio.stayease.dto.UserDto;
import com.crio.stayease.entities.User;
import com.crio.stayease.entities.enums.Role;
import com.crio.stayease.exceptions.UserNotFoundException;
import com.crio.stayease.mapper.Mapper;
import com.crio.stayease.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRepositoryServiceImpl implements UserRepositoryService {

    private final UserRepository userRepository;

    @Override
    public UserDto registerUser(String firstName, String lastName, String email, String password, Role role) {
        User user = User.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .email(email)
                    .password(password)
                    .role(role)
                    .build();
                    
        User savedUser = userRepository.save(user);
        return Mapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto findUserByEmail(String email) {
        String message = "Can't find user of email: " + email;
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(message));
        return Mapper.mapToUserDto(user);
    }
    
}
