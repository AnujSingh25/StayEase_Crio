package com.crio.stayease.repositoryServices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crio.stayease.dto.HotelDto;
import com.crio.stayease.entities.Hotel;
import com.crio.stayease.exceptions.HotelNotFoundException;
import com.crio.stayease.mapper.Mapper;
import com.crio.stayease.repositories.HotelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelRepositoryServiceImpl implements HotelRepositoryService {

    private final HotelRepository hotelRepository;

    @Override
    public HotelDto createHotel(String hotelName, String location, String description, int availableRooms) {
        Hotel hotel = Hotel.builder()
                      .name(hotelName)
                      .location(location)
                      .description(description)
                      .availableRooms(availableRooms)
                      .build();

        Hotel savedHotel = hotelRepository.save(hotel);
        return Mapper.mapToHotelDto(savedHotel);
    }

    @Override
    public HotelDto findHotelById(int hotelId) {
        String message = "Can't find hotel of hotelId: " + hotelId;
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new HotelNotFoundException(message));
        return Mapper.mapToHotelDto(hotel);
    }

    @Override
    public List<HotelDto> findAllHotels() {
        List<Hotel> hotels = hotelRepository.findAll();
        return Mapper.mapToHotelDtoList(hotels);
    }

    @Override
    public HotelDto saveHotel(HotelDto hotelDto) {
        Hotel savedHotel = hotelRepository.save(Mapper.mapToHotel(hotelDto));
        return Mapper.mapToHotelDto(savedHotel);
    }

    @Override
    public void deleteHotel(int hotelId) {
        String message = "Can't find hotel of hotelId: " + hotelId;
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new HotelNotFoundException(message));
        hotelRepository.delete(hotel);
    }

}
