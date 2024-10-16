package com.example;

import java.util.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Configuration
@ConfigurationProperties(prefix= "weather")
public class WeatherConfig {
    private String defaultCond ;
    public String getDefaultCond()
    {
        return defaultCond;
    }
    public void setDefaultCond(String defaultCond)
    {
        this.defaultCond=defaultCond;
    }
    private Map<String, TempRange> cityTemp = new HashMap<>();  // Map to hold city-specific temperature ranges

    public void setCityTemp(Map<String,TempRange> cityTemp)
    {
        this.cityTemp=cityTemp;
    }
    public Map<String, TempRange> getCityTemp()
    {
        return cityTemp;
    }


    public static class TempRange
    {
        private int min;
        private int max;
        public int getMin()
        {
            return min;
        }
        public void setMin(int min)
        {
            this.min=min;
        }
        public int getMax()
        {
            return max;
        }
        public void setMax(int max)
        {
            this.max=max;
        }
    }
}

