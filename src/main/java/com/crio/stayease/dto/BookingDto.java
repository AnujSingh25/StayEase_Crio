package com.crio.stayease.dto;

import java.time.LocalDate;

import com.crio.stayease.entities.enums.BookingStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"user", "bookedHotel"})
public class BookingDto {

    private int id;

    private UserDto user;

    private HotelBasicDto bookedHotel;

    private int guests;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private BookingStatus bookingStatus;

    private LocalDate bookingDate;
}
