package com.webkaps.rating.service.impl;

import com.webkaps.rating.exception.ResourceNotFoundException;
import com.webkaps.rating.model.Rating;
import com.webkaps.rating.repository.RatingRepository;
import com.webkaps.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingRepository ratingRepository;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllratings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("Rating","id",ratingId));
    }

    @Override
    public Rating getRatingByHotelId(String hotelId) {
        System.out.println("HHHH  ::: "+hotelId);
        return ratingRepository.findByHotelId(hotelId);
    }
}
