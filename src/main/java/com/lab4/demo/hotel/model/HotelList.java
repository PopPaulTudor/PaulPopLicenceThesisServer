package com.lab4.demo.hotel.model;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class HotelList{
    private List<Hotel> hotelList;

}