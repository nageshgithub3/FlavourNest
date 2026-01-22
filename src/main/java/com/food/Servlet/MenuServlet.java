package com.food.Servlet;

import com.food.dao.MenuDAO;
import com.food.dao.RestaurantDAO;
import com.food.daoimplementation.MenuDAOImpl;
import com.food.daoimplementation.RestaurantDAOImpl;
import com.food.model.Menu;
import com.food.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private MenuDAO menuDAO;
    private RestaurantDAO restaurantDAO;
    
    @Override
    public void init() {
        menuDAO = new MenuDAOImpl();
        restaurantDAO = new RestaurantDAOImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String restaurantIdStr = request.getParameter("restaurantId");
        
        if (restaurantIdStr != null) {
            int restaurantId = Integer.parseInt(restaurantIdStr);
            List<Menu> menuItems = menuDAO.getMenuByRestaurantId(restaurantId);
            Restaurant restaurant = restaurantDAO.getRestaurantById(restaurantId);
            
            request.setAttribute("menuItems", menuItems);
            request.setAttribute("restaurant", restaurant);
        } else {
            List<Menu> menuItems = menuDAO.getAllMenuItems();
            request.setAttribute("menuItems", menuItems);
        }
        
        request.getRequestDispatcher("menu.html").forward(request, response);
    }
}