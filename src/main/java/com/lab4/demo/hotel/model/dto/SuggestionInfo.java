package com.lab4.demo.hotel.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuggestionInfo {

    private String longitude;
    private String latitude;
    private String startDate;
    private String endDate;
    private String email;
}
