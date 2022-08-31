package com.lab4.demo.review;

import com.lab4.demo.label.Label;
import com.lab4.demo.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
