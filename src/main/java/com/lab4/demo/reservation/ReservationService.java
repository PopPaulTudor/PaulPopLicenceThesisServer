package com.lab4.demo.reservation;

import com.lab4.demo.reservation.model.Reservation;
import com.lab4.demo.reservation.model.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;

    private Reservation findById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group not found: " + id));
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public boolean create(Reservation reservation) {
        reservationRepository.save(reservation);
        return true;
    }
}
