package com.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        System.out.println("Adding reviews in controller");
        return reviewService.addReview(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
        review.setId(id);  // Setting ID for update
        return reviewService.updateReview(review);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
    // @GetMapping("/restaurant/{restaurantId}")
    // public ResponseEntity<List<Review>> getReviewsByRestaurantId(@PathVariable Long restaurantId) {
    //     try {
    //         List<Review> reviews = reviewService.getReviewsByRestaurantId(restaurantId);
    //         return ResponseEntity.ok(reviews);
    //     } catch (ReviewNotFoundException ex) {
    //         return ResponseEntity.notFound().build();
    //     }
    // }
}
