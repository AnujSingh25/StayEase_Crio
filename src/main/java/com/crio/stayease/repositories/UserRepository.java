package com.crio.stayease.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.stayease.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
