<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.food.model.CartItem" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart - JavaFoods</title>
    <link rel="stylesheet" href="cartStyle.css">
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
            <ul class="nav-menu">
                <li><a href="home.html">Home</a></li>
                <li><a href="menu.html">Menu</a></li>
                <li><a href="Restaurant.jsp">Restaurants</a></li>
                <li><a href="offers.html">Offers</a></li>
            </ul>
            <div class="nav-actions">
                <a href="cart" class="cart-btn active">
                    🛒 <span class="cart-count">
                        <%= request.getAttribute("cart") != null ? 
                            ((Collection<?>)request.getAttribute("cart")).size() : 0 %>
                    </span>
                </a>
                <a href="login.html" class="btn-primary">Sign In</a>
            </div>
        </div>
    </nav>

    <!-- Cart Section -->
    <section class="cart-section">
        <div class="container">
            <h1>Shopping Cart</h1>
            
            <% 
            Collection<CartItem> cart = (Collection<CartItem>) request.getAttribute("cart");
            Double total = (Double) request.getAttribute("total");
            
            if (cart != null && !cart.isEmpty()) {
            %>
            
            <div class="cart-content">
                <div class="cart-items">
                    <% for (CartItem item : cart) { %>
                    <div class="cart-item">
                        <img src="<%= item.getImagePath() %>" alt="<%= item.getItemName() %>">
                        <div class="item-details">
                            <h3><%= item.getItemName() %></h3>
                            <p class="item-price">₹<%= item.getPrice() %></p>
                        </div>
                        <div class="item-quantity">
                            <form action="cart" method="post" style="display: inline;">
                                <input type="hidden" name="action" value="update">
                                <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                                <button type="submit" name="quantity" value="<%= item.getQuantity() - 1 %>" 
                                        class="qty-btn">-</button>
                                <span class="qty"><%= item.getQuantity() %></span>
                                <button type="submit" name="quantity" value="<%= item.getQuantity() + 1 %>" 
                                        class="qty-btn">+</button>
                            </form>
                        </div>
                        <div class="item-total">
                            <p>₹<%= item.getSubtotal() %></p>
                        </div>
                        <form action="cart" method="post" class="remove-form">
                            <input type="hidden" name="action" value="remove">
                            <input type="hidden" name="menuId" value="<%= item.getMenuId() %>">
                            <button type="submit" class="btn-remove">×</button>
                        </form>
                    </div>
                    <% } %>
                </div>
                
                <div class="cart-summary">
                    <h2>Order Summary</h2>
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
                    <a href="checkout" class="btn-checkout">Proceed to Checkout</a>
                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="clear">
                        <button type="submit" class="btn-clear">Clear Cart</button>
                    </form>
                </div>
            </div>
            
            <% } else { %>
            
            <div class="empty-cart">
                <div class="empty-icon">🛒</div>
                <h2>Your cart is empty</h2>
                <p>Add some delicious items to get started!</p>
                <a href="menu.html" class="btn-primary">Browse Menu</a>
            </div>
            
            <% } %>
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