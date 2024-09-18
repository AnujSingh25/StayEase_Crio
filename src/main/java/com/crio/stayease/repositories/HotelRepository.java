package com.crio.stayease.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.stayease.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    
}
