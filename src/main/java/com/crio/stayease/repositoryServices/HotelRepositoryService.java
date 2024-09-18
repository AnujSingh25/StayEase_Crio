package com.crio.stayease.repositoryServices;

import java.util.List;

import com.crio.stayease.dto.HotelDto;

public interface HotelRepositoryService {
    
    HotelDto createHotel(String hotelName, String location, String description, int availableRooms);

    HotelDto findHotelById(int hotelId);

    List<HotelDto> findAllHotels();

    HotelDto saveHotel(HotelDto hotelDto);

    void deleteHotel(int hotelId);
    
}
