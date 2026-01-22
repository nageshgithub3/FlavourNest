package com.food.daoimplementation;

import com.food.dao.RestaurantDAO;
import com.food.model.Restaurant;
import com.food.utility.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAOImpl implements RestaurantDAO {
    
    @Override
    public int addRestaurant(Restaurant restaurant) {
        String query = "INSERT INTO restaurants (name, cuisine_type, address, phone_number, rating, delivery_time, is_active, image_path) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getCuisineType());
            pstmt.setString(3, restaurant.getAddress());
            pstmt.setString(4, restaurant.getPhoneNumber());
            pstmt.setDouble(5, restaurant.getRating());
            pstmt.setInt(6, restaurant.getDeliveryTime());
            pstmt.setBoolean(7, restaurant.isActive());
            pstmt.setString(8, restaurant.getImagePath());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        String query = "SELECT * FROM restaurants WHERE restaurant_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, restaurantId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractRestaurantFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "SELECT * FROM restaurants WHERE is_active = true";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                restaurants.add(extractRestaurantFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }
    
    @Override
    public List<Restaurant> getRestaurantsByCuisine(String cuisineType) {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "SELECT * FROM restaurants WHERE cuisine_type = ? AND is_active = true";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, cuisineType);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                restaurants.add(extractRestaurantFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }
    
    @Override
    public int updateRestaurant(Restaurant restaurant) {
        String query = "UPDATE restaurants SET name = ?, cuisine_type = ?, address = ?, phone_number = ?, rating = ?, delivery_time = ?, is_active = ?, image_path = ? WHERE restaurant_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, restaurant.getName());
            pstmt.setString(2, restaurant.getCuisineType());
            pstmt.setString(3, restaurant.getAddress());
            pstmt.setString(4, restaurant.getPhoneNumber());
            pstmt.setDouble(5, restaurant.getRating());
            pstmt.setInt(6, restaurant.getDeliveryTime());
            pstmt.setBoolean(7, restaurant.isActive());
            pstmt.setString(8, restaurant.getImagePath());
            pstmt.setInt(9, restaurant.getRestaurantId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public int deleteRestaurant(int restaurantId) {
        String query = "DELETE FROM restaurants WHERE restaurant_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, restaurantId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    private Restaurant extractRestaurantFromResultSet(ResultSet rs) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(rs.getInt("restaurant_id"));
        restaurant.setName(rs.getString("name"));
        restaurant.setCuisineType(rs.getString("cuisine_type"));
        restaurant.setAddress(rs.getString("address"));
        restaurant.setPhoneNumber(rs.getString("phone_number"));
        restaurant.setRating(rs.getDouble("rating"));
        restaurant.setDeliveryTime(rs.getInt("delivery_time"));
        restaurant.setActive(rs.getBoolean("is_active"));
        restaurant.setImagePath(rs.getString("image_path"));
        return restaurant;
    }
}