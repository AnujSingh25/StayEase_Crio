package com.crio.stayease.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;

import com.crio.stayease.dto.BookingDto;
import com.crio.stayease.dto.HotelBasicDto;
import com.crio.stayease.dto.HotelDto;
import com.crio.stayease.dto.UserDto;
import com.crio.stayease.entities.Booking;
import com.crio.stayease.entities.Hotel;
import com.crio.stayease.entities.User;

public class Mapper {
    
    private static ModelMapper modelMapper = new ModelMapper();

    public static User mapToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public static UserDto mapToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    private static Set<BookingDto> mapToBookingDtoSet(Set<Booking> bookings) {
        Set<BookingDto> bookingDtoSet = new HashSet<>();

        if(bookings == null)
            return bookingDtoSet;
            
        for(Booking booking : bookings) {
            bookingDtoSet.add(modelMapper.map(booking, BookingDto.class));
        }

        return bookingDtoSet;
    }

    public static HotelDto mapToHotelDto(Hotel hotel) {
        HotelDto hotelDto = HotelDto.builder()
                            .id(hotel.getId())
                            .name(hotel.getName())
                            .location(hotel.getLocation())
                            .description(hotel.getDescription())
                            .availableRooms(hotel.getAvailableRooms())
                            .bookings(mapToBookingDtoSet(hotel.getBookings()))
                            .build();

        return hotelDto;
    }

    public static HotelBasicDto mapToHotelBasicDto(HotelDto hotelDto) {
        return modelMapper.map(hotelDto, HotelBasicDto.class);
    }

    public static List<HotelBasicDto> mapToHotelBasicDtoList(List<HotelDto> hotelDtoList) {
        List<HotelBasicDto> hotelBasicDtoList = new ArrayList<>();

        for(HotelDto hotelDto : hotelDtoList) {
            hotelBasicDtoList.add(mapToHotelBasicDto(hotelDto));
        }

        return hotelBasicDtoList;
    }
    
    public static Hotel mapToHotel(HotelDto hotelDto) {
        return modelMapper.map(hotelDto, Hotel.class);
    }

    public static List<HotelDto> mapToHotelDtoList(List<Hotel> hotels) {
        List<HotelDto> hotelDtoList = new ArrayList<>();

        for(Hotel hotel : hotels) {
            hotelDtoList.add(mapToHotelDto(hotel));
        }

        return hotelDtoList;
    }

    public static Booking mapToBooking(BookingDto bookingDto) {
        return modelMapper.map(bookingDto, Booking.class);
    }

    public static BookingDto mapToBookingDto(Booking booking) {
        return modelMapper.map(booking, BookingDto.class);
    }

    public static Set<Booking> mapToBookingSet(Set<BookingDto> bookingDtoSet) {
        Set<Booking> bookingSet = new HashSet<>();

        for(BookingDto bookingDto : bookingDtoSet) {
            bookingSet.add(mapToBooking(bookingDto));
        }

        return bookingSet;
    }
}
