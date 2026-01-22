package com.food.Servlet;

import com.food.dao.OrderDAO;
import com.food.dao.OrderItemDAO;
import com.food.daoimplementation.OrderDAOImpl;
import com.food.daoimplementation.OrderItemDAOImpl;
import com.food.model.CartItem;
import com.food.model.Order;
import com.food.model.OrderItem;
import com.food.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;

@jakarta.servlet.annotation.WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    
    @Override
    public void init() {
        orderDAO = new OrderDAOImpl();
        orderItemDAO = new OrderItemDAOImpl();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("login");
            return;
        }
        
        @SuppressWarnings("unchecked")
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        
        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("cart");
            return;
        }
        
        String paymentMethod = request.getParameter("paymentMethod");
        String deliveryAddress = request.getParameter("deliveryAddress");
        
        // Calculate total
        double total = 0;
        int restaurantId = 0;
        for (CartItem item : cart.values()) {
            total += item.getSubtotal();
            restaurantId = item.getRestaurantId();
        }
        
        // Create order
        Order order = new Order();
        order.setUserId(user.getUserId());
        order.setRestaurantId(restaurantId);
        order.setTotalAmount(total);
        order.setStatus("Pending");
        order.setPaymentMethod(paymentMethod);
        order.setDeliveryAddress(deliveryAddress);
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        
        int orderId = orderDAO.createOrder(order);
        
        if (orderId > 0) {
            // Add order items
            for (CartItem item : cart.values()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderId(orderId);
                orderItem.setMenuId(item.getMenuId());
                orderItem.setQuantity(item.getQuantity());
                orderItem.setPrice(item.getPrice());
                orderItem.setSubtotal(item.getSubtotal());
                orderItemDAO.addOrderItem(orderItem);
            }
            
            // Clear cart
            cart.clear();
            session.setAttribute("cart", cart);
            
            response.sendRedirect("orderConfirmation.html?orderId=" + orderId);
        } else {
            request.setAttribute("errorMessage", "Order failed. Please try again.");
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("login");
            return;
        }
        
        @SuppressWarnings("unchecked")
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
        
        if (cart == null || cart.isEmpty()) {
            response.sendRedirect("cart");
            return;
        }
        
        double total = 0;
        for (CartItem item : cart.values()) {
            total += item.getSubtotal();
        }
        
        request.setAttribute("cart", cart.values());
        request.setAttribute("total", total);
        request.setAttribute("user", user);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }
}