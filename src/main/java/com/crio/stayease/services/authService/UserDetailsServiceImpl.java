package com.crio.stayease.services.authService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.crio.stayease.dto.UserDto;
import com.crio.stayease.mapper.Mapper;
import com.crio.stayease.repositoryServices.UserRepositoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepositoryService userRepositoryService;

    // -->
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDto userDto = userRepositoryService.findUserByEmail(username);
        return Mapper.mapToUser(userDto);
    }

}
