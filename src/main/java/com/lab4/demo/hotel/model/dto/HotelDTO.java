package com.lab4.demo.hotel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

    private String name;
    private String address;
    private Long score;
    private Long similarity;
}
