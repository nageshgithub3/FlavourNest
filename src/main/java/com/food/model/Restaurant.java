package com.food.model;

public class Restaurant {
    private int restaurantId;
    private String name;
    private String cuisineType;
    private String address;
    private String phoneNumber;
    private double rating;
    private int deliveryTime;
    private boolean isActive;
    private String imagePath;
    
    // Constructors
    public Restaurant() {}
    
    public Restaurant(int restaurantId, String name, String cuisineType, 
                     String address, String phoneNumber, double rating, 
                     int deliveryTime, boolean isActive, String imagePath) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.cuisineType = cuisineType;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.deliveryTime = deliveryTime;
        this.isActive = isActive;
        this.imagePath = imagePath;
    }
    
    // Getters and Setters
    public int getRestaurantId() {
        return restaurantId;
    }
    
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCuisineType() {
        return cuisineType;
    }
    
    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public double getRating() {
        return rating;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public int getDeliveryTime() {
        return deliveryTime;
    }
    
    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    public String getImagePath() {
        return imagePath;
    }
    
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}