package com.crio.stayease.exchanges;

import java.util.List;

import com.crio.stayease.dto.HotelBasicDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetAllBasicHotelsResponse {

    private List<HotelBasicDto> hotelBasicDtoList;

}
