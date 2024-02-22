package com.webkaps.rating.repository;

import com.webkaps.rating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {
    Rating findByHotelId(String hotelId);
}
