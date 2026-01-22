package com.food.dao;

import com.food.model.OrderItem;
import java.util.List;

public interface OrderItemDAO {
    int addOrderItem(OrderItem orderItem);
    List<OrderItem> getOrderItemsByOrderId(int orderId);
    int deleteOrderItem(int orderItemId);
}