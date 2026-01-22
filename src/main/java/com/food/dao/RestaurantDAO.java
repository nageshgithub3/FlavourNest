package com.food.dao;

import com.food.model.Restaurant;
import java.util.List;

public interface RestaurantDAO {
    int addRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(int restaurantId);
    List<Restaurant> getAllRestaurants();
    List<Restaurant> getRestaurantsByCuisine(String cuisineType);
    int updateRestaurant(Restaurant restaurant);
    int deleteRestaurant(int restaurantId);
}