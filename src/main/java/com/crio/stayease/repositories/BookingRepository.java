package com.crio.stayease.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crio.stayease.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    
}
