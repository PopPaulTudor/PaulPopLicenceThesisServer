package com.lab4.demo.hotel;

import com.lab4.demo.hotel.model.dto.HotelDTO;
import com.lab4.demo.hotel.model.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelDTO toDto(Hotel hotel);

    Hotel fromDto(HotelDTO dto);
}
