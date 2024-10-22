package com.example;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepo;
    @Autowired
    public ReviewService(ReviewRepository reviewRepo)
    {
        this.reviewRepo=reviewRepo;
    }
    public List<Review> getAllReviews()
    {
        return reviewRepo.findAll();
    }
    public Review addReview(Review r)
    {
        System.out.println("Adding reviews in service class");
        return reviewRepo.save(r);
    }
    public void deleteReview(Long id){
        reviewRepo.deleteById(id);
    }
    public Review updateReview(Review r) {
        return reviewRepo.save(r);
    }

    public List<Review> getReviewsByRestaurantId(Long restaurantId) {
        List<Review> reviews = reviewRepo.findByRestaurantId(restaurantId);
        
        if (reviews == null || reviews.isEmpty()) {
            throw new RuntimeException("No reviews found for restaurant with ID: " + restaurantId);
        }
        
        return reviews;
    }
}
