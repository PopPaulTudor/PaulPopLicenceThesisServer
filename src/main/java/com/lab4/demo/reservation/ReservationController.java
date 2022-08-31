package com.lab4.demo.reservation;


import com.lab4.demo.reservation.model.Reservation;
import com.lab4.demo.reservation.model.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lab4.demo.UrlMapping.RESERVATION;

@RestController
@RequestMapping(RESERVATION)
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/create")
    public boolean createReservation(@RequestBody Reservation reservation) {
        return reservationService.create(reservation);
    }

    @GetMapping
    public List<Reservation> allGroups() {
        return reservationService.findAll();
    }

}