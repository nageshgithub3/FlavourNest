package com.food.Servlet;

import com.food.dao.MenuDAO;
import com.food.daoimplementation.MenuDAOImpl;
import com.food.model.CartItem;
import com.food.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private MenuDAO menuDAO;
    
    @Override
    public void init() {
        menuDAO = new MenuDAOImpl();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        // Get or create cart
        @SuppressWarnings("unchecked")
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        
        if ("add".equals(action)) {
            int menuId = Integer.parseInt(request.getParameter("menuId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            
            Menu menu = menuDAO.getMenuItemById(menuId);
            if (menu != null) {
                if (cart.containsKey(menuId)) {
                    CartItem item = cart.get(menuId);
                    item.setQuantity(item.getQuantity() + quantity);
                } else {
                    CartItem item = new CartItem(menuId, menu.getRestaurantId(), 
                                                menu.getItemName(), menu.getPrice(), 
                                                quantity, menu.getImagePath());
                    cart.put(menuId, item);
                }
            }
        } else if ("update".equals(action)) {
            int menuId = Integer.parseInt(request.getParameter("menuId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            
            if (cart.containsKey(menuId)) {
                if (quantity > 0) {
                    cart.get(menuId).setQuantity(quantity);
                } else {
                    cart.remove(menuId);
                }
            }
        } else if ("remove".equals(action)) {
            int menuId = Integer.parseInt(request.getParameter("menuId"));
            cart.remove(menuId);
        } else if ("clear".equals(action)) {
            cart.clear();
        }
        
        session.setAttribute("cart", cart);
        response.sendRedirect("cart");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }
        
        double total = 0;
        for (CartItem item : cart.values()) {
            total += item.getSubtotal();
        }
        
        request.setAttribute("cart", cart.values());
        request.setAttribute("total", total);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
    }
}