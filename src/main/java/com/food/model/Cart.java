package com.food.model;

public class Cart {
    private int cartId;
    private int userId;
    private int menuId;
    private int quantity;
    private double price;
    
    // Constructors
    public Cart() {}
    
    public Cart(int cartId, int userId, int menuId, int quantity, double price) {
        this.cartId = cartId;
        this.userId = userId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.price = price;
    }
    
    // Getters and Setters
    public int getCartId() {
        return cartId;
    }
    
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getMenuId() {
        return menuId;
    }
    
    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
}