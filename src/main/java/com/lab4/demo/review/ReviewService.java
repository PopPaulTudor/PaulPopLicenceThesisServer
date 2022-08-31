package com.lab4.demo.review;

import com.lab4.demo.reservation.ReservationMapper;
import com.lab4.demo.reservation.ReservationRepository;
import com.lab4.demo.reservation.model.Reservation;
import com.lab4.demo.reservation.model.dto.ReservationDTO;
import com.lab4.demo.review.model.Review;
import com.lab4.demo.review.model.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private ReviewMapper reviewMapper;

    private ReviewRepository reviewRepository;


    private Review findById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group not found: " + id));
    }

    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll().stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }
}
