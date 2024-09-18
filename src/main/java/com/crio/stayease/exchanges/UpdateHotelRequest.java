package com.crio.stayease.exchanges;

import java.util.Set;

import com.crio.stayease.dto.BookingDto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateHotelRequest {

    private String hotelName;

    private String location;

    private String description;

    private int availableRooms;

    private Set<BookingDto> bookingDtoList;

}
