package com.crio.stayease.services;

import org.springframework.security.core.userdetails.UserDetails;

import com.crio.stayease.dto.BookingDto;
import com.crio.stayease.dto.HotelBasicDto;
import com.crio.stayease.dto.HotelDto;
import com.crio.stayease.exchanges.BookRoomRequest;
import com.crio.stayease.exchanges.CreateHotelRequest;
import com.crio.stayease.exchanges.GetAllBasicHotelsResponse;
import com.crio.stayease.exchanges.UpdateHotelRequest;

public interface HotelService {
    
    HotelDto createHotel(CreateHotelRequest createHotelRequest);

    BookingDto createBooking(int hotelId, BookRoomRequest bookRoomsRequest, UserDetails userDetails);
    
    HotelBasicDto findHotelByIdForCustomers(int hotelId);

    GetAllBasicHotelsResponse findAllHotelsForCustomers();

    HotelDto findHotelByIdForManager(int hotelId);

    HotelDto updateHotel(int hotelId, UpdateHotelRequest updateHotelRequest);

    HotelDto saveHotel(HotelDto hotelDto);

    String deleteHotel(int hotelId);
}
