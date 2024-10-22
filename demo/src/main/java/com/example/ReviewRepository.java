package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByRestaurantId(long restaurant_id);
    
}