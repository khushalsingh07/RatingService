package com.webkaps.rating.service;

import com.webkaps.rating.model.Rating;

import java.util.List;

public interface RatingService {
     Rating saveRating(Rating rating);

     List<Rating> getAllratings();

     Rating getRatingById(String ratingId);

     Rating getRatingByHotelId(String hotelId);

     // Code for delete rating

    //Code for update rating
}
