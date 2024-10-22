package com.example;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByCity(String city);
}