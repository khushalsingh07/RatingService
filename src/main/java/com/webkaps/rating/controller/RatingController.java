package com.webkaps.rating.controller;

import com.webkaps.rating.model.Rating;
import com.webkaps.rating.service.RatingService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user-rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
        String randomUUID = UUID.randomUUID().toString();
        rating.setRatingId(randomUUID);
        Rating savedRating  = ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> allRatings = ratingService.getAllratings();
        return ResponseEntity.ok(allRatings);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId){
        Rating rating = ratingService.getRatingById(ratingId);
        return ResponseEntity.ok(rating);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        List<Rating> ratingByHotelId = ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok(ratingByHotelId);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        List<Rating> ratingByUserId = ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(ratingByUserId);
    }
}
