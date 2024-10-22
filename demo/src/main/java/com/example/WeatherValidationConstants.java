package com.example;

public class WeatherValidationConstants {
    // Constants for city validation
    public static final String CITY_EMPTY = "City cannot be empty";
    public static final int CITY_MIN_LENGTH = 3;
    public static final int CITY_MAX_LENGTH = 20;
    public static final String CITY_SIZE = "City must be between " + CITY_MIN_LENGTH + " and " + CITY_MAX_LENGTH + " characters";
    
    // Constants for temperature validation
    public static final int TEMP_MIN = -50;
    public static final int TEMP_MAX = 50;
    public static final String TEMP_TOO_LOW = "Temperature cannot be less than " + TEMP_MIN + "°C";
    public static final String TEMP_TOO_HIGH = "Temperature cannot be greater than " + TEMP_MAX + "°C";

    // Constants for weather condition validation
    public static final String CONDITION_EMPTY = "Weather condition cannot be empty";
    public static final int CONDITION_MIN_LENGTH = 3;
    public static final int CONDITION_MAX_LENGTH = 20;
    public static final String CONDITION_SIZE = "Weather condition must be between " + CONDITION_MIN_LENGTH + " and " + CONDITION_MAX_LENGTH + " characters";
    public static final String CONDITION_PATTERN = "^(sunny|rainy|cloudy|snowy)$";
    public static final String CONDITION_INVALID = "Weather condition must be sunny, cloudy, rainy, or snowy"; 
}
