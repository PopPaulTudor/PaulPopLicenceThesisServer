package com.lab4.demo.reservation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {

    private String userId;
    private String hotelId;
    private Long startDate;
    private Long endDate;
    private double price;
}
