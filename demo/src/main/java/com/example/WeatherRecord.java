package com.example;
import org.springframework.stereotype.Component;

import org.springframework.context.annotation.Scope;
@Component
@Scope("prototype")
public class WeatherRecord {
    private String city;
    private String condition;
    private int temp;
   
    // public void initialize(String city,String condition)
    // {
    //     this.city=city;
    //     this.condition=condition;
    // }
    public void initialize(String city,int temp)
    {
        this.city=city;
        this.temp=temp;
    }
    public String getCity()
    {
        return city;
    }
    public String getCond()
    {
        return condition;
    }
    public void setCity(String city)
    {
        this.city=city;
    }
    public void setCond(String condition)
    {
        this.condition=condition;
    }
    public void setTemp(int temp)
    {
        this.temp=temp;
    }
    public int getTemp()
    {
        return temp;
    }
}
