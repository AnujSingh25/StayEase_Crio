package com.crio.stayease.repositoryServices;

import java.time.LocalDate;

import com.crio.stayease.dto.BookingDto;

public interface BookingRepositoryService {
    
    BookingDto createBooking(int hotelId, String userEmail, int guests, LocalDate checkInDate, LocalDate checkOutDate);

    BookingDto updateBooking(BookingDto bookingDto);

    BookingDto findBookingById(int bookingId);

    void cancelBooking(BookingDto bookingDto);
}
