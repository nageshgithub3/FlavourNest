package com.food.dao;

import com.food.model.Menu;
import java.util.List;

public interface MenuDAO {
    int addMenuItem(Menu menu);
    Menu getMenuItemById(int menuId);
    List<Menu> getMenuByRestaurantId(int restaurantId);
    List<Menu> getAllMenuItems();
    int updateMenuItem(Menu menu);
    int deleteMenuItem(int menuId);
}