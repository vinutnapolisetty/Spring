package com.example;
import org.springframework.stereotype.Component;
import jakarta.persistence.*;

// import org.springframework.stereotype.Component;

import java.lang.annotation.Inherited;

// import org.springframework.context.annotation.Scope;
// @Component
// @Scope("prototype")
// public class WeatherRecord {
//     private String city;
//     private String condition;
//     private int temp;
   
//     // public void initialize(String city,String condition)
//     // {
//     //     this.city=city;
//     //     this.condition=condition;
//     // }
//     public void initialize(String city,int temp)
//     {
//         this.city=city;
//         this.temp=temp;
//     }
//     public String getCity()
//     {
//         return city;
//     }
//     public String getCond()
//     {
//         return condition;
//     }
//     public void setCity(String city)
//     {
//         this.city=city;
//     }
//     public void setCond(String condition)
//     {
//         this.condition=condition;
//     }
//     public void setTemp(int temp)
//     {
//         this.temp=temp;
//     }
//     public int getTemp()
//     {
//         return temp;
//     }
// }

@Entity
@Table(name="weather_records")
@Component
public class WeatherRecord{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(nullable=false,unique=true)
    private String city;
    @Column(nullable=false)
    private int temp;
    @Column(nullable=false)
    private String weathercondition;
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
    public Long getId(){
        return id;
    }   
    public void setId(Long id){
        this.id = id;
    }
    public String getCity()
    {
        return city;
    }
    public String getWeathercondition()
    {
        return weathercondition;
    }
    public void setCity(String city)
    {
        this.city=city;
    }
    public void setWeathercondition(String weathercondition)
    {
        this.weathercondition=weathercondition;
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
