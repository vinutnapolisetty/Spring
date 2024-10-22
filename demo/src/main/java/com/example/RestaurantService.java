package com.example;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    private final RestaurantRepository rr;
    @Autowired
    public RestaurantService(RestaurantRepository rr)
    {
        this.rr=rr;
    }
    public List<Restaurant> getAllRest()
    {
        return rr.findAll();
    }
    public Restaurant addRestaurant(Restaurant r)
    {
        System.out.println("Restaurant added in service class");
        return rr.save(r);
    }
    public void deleteRestaurant(Long id){
        rr.deleteById(id);
    }
    public Restaurant updateRestaurant(Restaurant r) {
        return rr.save(r);
    }

    public Restaurant getRestaurantByCity(String city) {
        return rr.findByCity(city)
                .orElseThrow(() -> new RuntimeException("Restaurant not found in a city"));
    }
}
