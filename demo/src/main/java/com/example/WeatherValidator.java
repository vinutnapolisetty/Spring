package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class WeatherValidator {
    public void validateWeatherCond(WeatherRequestDTO weatherRequestDTO)
    {
        List<String> v=new ArrayList<>();
        if(weatherRequestDTO.getTemp()>30 && "Snowy".equals(weatherRequestDTO.getWeatherCondition()))
        {
            v.add("Snowy weather is not allowed when temperature is above 30");
        }
        if(weatherRequestDTO.getTemp()<30 && "Sunny".equals(weatherRequestDTO.getWeatherCondition()))
        {
            v.add("Sunny weather is not allowed when temperature is below 30");
        }
        if(v.isEmpty())
        return;
        throw new WeatherValidationException(String.join(" ",v),v);
    }
}
