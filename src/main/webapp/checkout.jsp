<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.food.model.CartItem, com.food.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout - FlavourNest</title>
    <link rel="stylesheet" href="checkoutStyle.css">
    <link rel="stylesheet" href="common.css">
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar">
        <div class="nav-container">
            <div class="logo">
                <span class="logo-icon">
    <img src="assets/images/menu/flavour.png" alt="FlavorNest Logo">
</span>
                <span class="logo-text">FlavourNest</span>
            </div>
        </div>
    </nav>

    <!-- Checkout Section -->
    <section class="checkout-section">
        <div class="container">
            <h1>Checkout</h1>
            
            <% 
            User user = (User) request.getAttribute("user");
            Collection<CartItem> cart = (Collection<CartItem>) request.getAttribute("cart");
            Double total = (Double) request.getAttribute("total");
            %>
            
            <div class="checkout-content">
                <div class="checkout-form">
                    <form action="checkout" method="post">
                        <div class="form-section">
                            <h2>Delivery Information</h2>
                            
                            <div class="form-group">
                                <label for="name">Full Name</label>
                                <input type="text" id="name" name="name" 
                                       value="<%= user.getUsername() %>" readonly>
                            </div>
                            
                            <div class="form-group">
                                <label for="phone">Phone Number</label>
                                <input type="tel" id="phone" name="phone" 
                                       value="<%= user.getPhoneNumber() %>" readonly>
                            </div>
                            
                            <div class="form-group">
                                <label for="deliveryAddress">Delivery Address</label>
                                <textarea id="deliveryAddress" name="deliveryAddress" 
                                          rows="4" required><%= user.getAddress() %></textarea>
                            </div>
                        </div>
                        
                        <div class="form-section">
                            <h2>Payment Method</h2>
                            
                            <div class="payment-options">
                                <label class="payment-option">
                                    <input type="radio" name="paymentMethod" value="COD" checked>
                                    <div class="option-content">
                                        <span class="icon">💵</span>
                                        <div>
                                            <strong>Cash on Delivery</strong>
                                            <p>Pay when you receive</p>
                                        </div>
                                    </div>
                                </label>
                                
                                <label class="payment-option">
                                    <input type="radio" name="paymentMethod" value="Card">
                                    <div class="option-content">
                                        <span class="icon">💳</span>
                                        <div>
                                            <strong>Card Payment</strong>
                                            <p>Credit or Debit card</p>
                                        </div>
                                    </div>
                                </label>
                                
                                <label class="payment-option">
                                    <input type="radio" name="paymentMethod" value="UPI">
                                    <div class="option-content">
                                        <span class="icon">📱</span>
                                        <div>
                                            <strong>UPI</strong>
                                            <p>Pay using UPI apps</p>
                                        </div>
                                    </div>
                                </label>
                            </div>
                        </div>
                        
                        <button type="submit" class="btn-place-order">Place Order</button>
                    </form>
                </div>
                
                <div class="order-summary">
                    <h2>Order Summary</h2>
                    
                    <div class="order-items">
                        <% for (CartItem item : cart) { %>
                        <div class="order-item">
                            <img src="<%= item.getImagePath() %>" alt="<%= item.getItemName() %>">
                            <div class="item-info">
                                <h4><%= item.getItemName() %></h4>
                                <p>Qty: <%= item.getQuantity() %></p>
                            </div>
                            <span class="item-price">₹<%= item.getSubtotal() %></span>
                        </div>
                        <% } %>
                    </div>
                    
                    <div class="summary-details">
                        <div class="summary-row">
                            <span>Subtotal</span>
                            <span>₹<%= String.format("%.2f", total) %></span>
                        </div>
                        <div class="summary-row">
                            <span>Delivery Fee</span>
                            <span>₹40.00</span>
                        </div>
                        <div class="summary-row">
                            <span>Tax (5%)</span>
                            <span>₹<%= String.format("%.2f", total * 0.05) %></span>
                        </div>
                        <hr>
                        <div class="summary-row total">
                            <span>Total</span>
                            <span>₹<%= String.format("%.2f", total + 40 + (total * 0.05)) %></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <p>&copy; 2025 FlavourNest. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>