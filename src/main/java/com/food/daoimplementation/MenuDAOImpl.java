package com.food.daoimplementation;

import com.food.dao.MenuDAO;
import com.food.model.Menu;
import com.food.utility.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAOImpl implements MenuDAO {
    
    @Override
    public int addMenuItem(Menu menu) {
        String query = "INSERT INTO menu (restaurant_id, item_name, description, price, category, is_available, image_path, rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, menu.getRestaurantId());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setString(5, menu.getCategory());
            pstmt.setBoolean(6, menu.isAvailable());
            pstmt.setString(7, menu.getImagePath());
            pstmt.setDouble(8, menu.getRating());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public Menu getMenuItemById(int menuId) {
        String query = "SELECT * FROM menu WHERE menu_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, menuId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractMenuFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Menu> getMenuByRestaurantId(int restaurantId) {
        List<Menu> menuItems = new ArrayList<>();
        String query = "SELECT * FROM menu WHERE restaurant_id = ? AND is_available = true";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, restaurantId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                menuItems.add(extractMenuFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuItems;
    }
    
    @Override
    public List<Menu> getAllMenuItems() {
        List<Menu> menuItems = new ArrayList<>();
        String query = "SELECT * FROM menu WHERE is_available = true";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                menuItems.add(extractMenuFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuItems;
    }
    
    @Override
    public int updateMenuItem(Menu menu) {
        String query = "UPDATE menu SET restaurant_id = ?, item_name = ?, description = ?, price = ?, category = ?, is_available = ?, image_path = ?, rating = ? WHERE menu_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, menu.getRestaurantId());
            pstmt.setString(2, menu.getItemName());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice());
            pstmt.setString(5, menu.getCategory());
            pstmt.setBoolean(6, menu.isAvailable());
            pstmt.setString(7, menu.getImagePath());
            pstmt.setDouble(8, menu.getRating());
            pstmt.setInt(9, menu.getMenuId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public int deleteMenuItem(int menuId) {
        String query = "DELETE FROM menu WHERE menu_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, menuId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    private Menu extractMenuFromResultSet(ResultSet rs) throws SQLException {
        Menu menu = new Menu();
        menu.setMenuId(rs.getInt("menu_id"));
        menu.setRestaurantId(rs.getInt("restaurant_id"));
        menu.setItemName(rs.getString("item_name"));
        menu.setDescription(rs.getString("description"));
        menu.setPrice(rs.getDouble("price"));
        menu.setCategory(rs.getString("category"));
        menu.setAvailable(rs.getBoolean("is_available"));
        menu.setImagePath(rs.getString("image_path"));
        menu.setRating(rs.getDouble("rating"));
        return menu;
    }
}