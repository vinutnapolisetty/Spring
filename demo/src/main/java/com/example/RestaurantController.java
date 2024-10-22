package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
@RestController
@RequestMapping("api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService rests;
    @GetMapping
    public List<Restaurant> getAllRest()
    {
        return rests.getAllRest();
    }
    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        System.out.println("In Controller");
        return rests.addRestaurant(restaurant);
    }
//     @PostMapping
// public ResponseEntity<Restaurant> addRestaurant(@RequestBody @Valid Restaurant restaurant) {
//     try {
//         Restaurant savedRestaurant = rests.addRestaurant(restaurant);
//         return ResponseEntity.status(HttpStatus.CREATED).body(savedRestaurant);
//     } catch (Exception e) {
//         // Log the exception for debugging purposes
//         e.printStackTrace();
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//     }
//}
    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        restaurant.setId(id);  // Setting ID for update
        return rests.updateRestaurant(restaurant);
    }
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        rests.deleteRestaurant(id);
    }
    @GetMapping("/{city}")
    public ResponseEntity<Restaurant> getRestaurantByCity(@PathVariable @NotBlank String city) {
        Restaurant restaurant = rests.getRestaurantByCity(city);
        return restaurant != null ? ResponseEntity.ok(restaurant) : ResponseEntity.notFound().build();
    }
}
