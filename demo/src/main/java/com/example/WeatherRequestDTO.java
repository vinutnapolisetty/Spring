package com.example;

import javax.validation.constraints.*;

public class WeatherRequestDTO {
    @NotBlank(message="City cannot be empty")
    @Size(min=3, max=20, message="City must be between 3 to 20 characters")
    private String city;

    @Min(value=-50,message="Temperature cannot be less than -50")
    @Max(value=50, message="Temperature cannot be greater than 50")
    private int temp;

    @NotBlank(message="Weather condition cannot be empty")
    @Size(min=3,max=20,message = "Weather condition must be between 3 to 20 characters")
    @Pattern(regexp = "^(sunny|rainy|cloudy|snowy)$",message = "Weather condition must be sunny, cloudy, rainy, snowy")
    private String weathercondition;
    public WeatherRequestDTO(String city,int temp,String weathercondition)
    {
        this.temp=temp;
        this.city=city;
        this.weathercondition=weathercondition;
    }
    public void setCity(String city)
    {
        this.city=city;
    }
    public String getCity()
    {
        return city;
    }
    public void setTemp(int temp)
    {
        this.temp=temp;
    }
    public int getTemp()
    {
        return temp;
    }
    public void setWeatherCondition(String weathercondition)
    {
        this.weathercondition=weathercondition;
    }
    public String getWeatherCondition()
    {
        return weathercondition;
    }
}
