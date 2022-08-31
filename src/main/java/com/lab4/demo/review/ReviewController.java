package com.lab4.demo.review;

import com.lab4.demo.review.model.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.lab4.demo.UrlMapping.REVIEW;

@RestController
@RequestMapping(REVIEW)
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDTO> allReviews() {
        return reviewService.findAll();
    }



}
