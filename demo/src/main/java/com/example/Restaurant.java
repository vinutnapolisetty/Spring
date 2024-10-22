package com.example;

import org.springframework.stereotype.Component;
import java.util.*;

import javax.validation.constraints.NotNull;

import jakarta.persistence.*;


@Entity
@Table(name="restaurant")
@Component
public class Restaurant {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    @NotNull
    private String name;
    @Column(nullable=false)
    private String cuisine;
    @Column(nullable=false)
    private String city;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Review> reviews;
    public Restaurant() {
        // No-argument constructor
    }
    
    public Restaurant(String name, String cuisine, String city) {
        this.name = name;
        this.cuisine = cuisine;
        this.city = city;
    }
    
    // public void initialize(String name,String city)
    // {
    //     this.city=city;
    //     this.name=name;
    // }
    public Long getId(){
        return id;
    }   
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }   
    public void setName(String name){
        this.name=name;
    }
    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city=city;
    }
    public String getCuisine() {
        return cuisine;
    }
    public void setCuisine(String cuisine)
    {
        this.cuisine=cuisine;
    }
    public void setReviews(List<Review> reviews)
    {
        this.reviews=reviews;
    }
    public List<Review> getReviews()
    {
        return reviews;
    }
}
