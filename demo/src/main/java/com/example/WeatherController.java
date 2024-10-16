package com.example;

import javax.validation.constraints.NotBlank;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/weather")
@Validated
public class WeatherController {
    private final WeatherService ws;
    @Autowired
    WeatherController(WeatherService ws)
    {
        this.ws=ws;
    }
    @GetMapping("/{city}")
    public String getWeather(@PathVariable @NotBlank String city)
    {
        return ws.getWeather(city);
        //return "The weather in "+ city +" is nice today";
    }
    @PostMapping("/{city}")
    public String updateWeather(@PathVariable String city, @RequestParam int temperature) {
        ws.updateWeather(city, temperature);
        return "Weather updated for " + city;
    }
    @GetMapping
    public Map<String, String> getAllWeather() {
        return ws.getAllWeatherData();
    }
    // public String updateWeather(@PathVariable String city, @PathVariable String condition)
    // {
    //     ws.updateWeather(city, condition);
    //     return "Weather updated for "+ city;
    // }


    // @GetMapping("/api/weather/{city}/{degree}")
    // public String getWeather(@PathVariable String city,@PathVariable int degree)
    // {
    //     return "The weather in "+ city +" is "+degree+" degree celsius today";
    // }

}
