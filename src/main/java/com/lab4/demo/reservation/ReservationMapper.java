package com.lab4.demo.reservation;

import com.lab4.demo.reservation.model.Reservation;
import com.lab4.demo.reservation.model.dto.ReservationDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ReservationMapper {


    ReservationDTO toDto(Reservation reservation);

    Reservation fromDto(ReservationDTO dto);

}
