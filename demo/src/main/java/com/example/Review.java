package com.example;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Table(name="reviews")
@Component
public class Review {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Column(nullable=false)
    private String reviewerName;
    @Column(nullable=false)
    private int rating;
    @Column(nullable=false)
    private String comment;
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)

    private Restaurant restaurant;
    public Review() {}

    // Constructor to initialize fields
    public Review(String reviewerName, int rating, String comment, Restaurant restaurant) {
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.comment = comment;
        this.restaurant = restaurant;
    }
    public Long getId(){
        return id;
    }   
    public void setId(long id){
        this.id = id;
    }
    public String getComment()
    {
        return comment;
    }
    public void setComment(String comment)
    {
        this.comment=comment;
    }
    public String getReviewerName() { // Corrected method name
        return reviewerName; // Return the correct field
    }

    public void setReviewerName(String reviewerName) { // Corrected method name
        this.reviewerName = reviewerName;
    }

    public int getRating(){
        return rating;
    }   
    public void setRating(int rating){
        this.rating=rating;
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
