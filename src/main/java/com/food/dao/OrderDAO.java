package com.food.dao;

import com.food.model.Order;
import java.util.List;

public interface OrderDAO {
    int createOrder(Order order);
    Order getOrderById(int orderId);
    List<Order> getOrdersByUserId(int userId);
    List<Order> getAllOrders();
    int updateOrderStatus(int orderId, String status);
    int deleteOrder(int orderId);
}