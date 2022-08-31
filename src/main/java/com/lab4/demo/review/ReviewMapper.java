package com.lab4.demo.review;

import com.lab4.demo.review.model.Review;
import com.lab4.demo.review.model.dto.ReviewDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper {


    ReviewDTO toDto(Review review);

    Review fromDto(ReviewDTO dto);

}
