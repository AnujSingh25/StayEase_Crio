package com.crio.stayease.services;

import org.springframework.security.core.userdetails.UserDetails;

import com.crio.stayease.dto.BookingDto;
import com.crio.stayease.exchanges.BookRoomRequest;

public interface BookingService {
    
    BookingDto bookRoom(int hotelId, BookRoomRequest bookRoomsRequest, UserDetails userDetails);

    BookingDto checkIn(int bookingId);

    BookingDto checkOut(int bookingId);

    String cancelBooking(int bookingId);
}
