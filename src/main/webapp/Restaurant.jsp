<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.food.model.Restaurant, com.food.dao.RestaurantDAO, com.food.daoimplementation.RestaurantDAOImpl" %>
<%
    RestaurantDAO restaurantDAO = new RestaurantDAOImpl();
    List<Restaurant> restaurants = restaurantDAO.getAllRestaurants();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurants - FlavorNest</title>
    <link rel="stylesheet" href="Restaurant.css">
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
                <span class="logo-text">FlavorNest</span>
            </div>
            <ul class="nav-menu">
                <li><a href="home.html">Home</a></li>
                <li><a href="menu.html">Menu</a></li>
                <li><a href="Restaurant.jsp" class="active">Restaurants</a></li>
                <li><a href="offers.html">Offers</a></li>
            </ul>
            <div class="nav-actions">
                <a href="cart" class="cart-btn">
                    🛒 <span class="cart-count">0</span>
                </a>
                <a href="login.html" class="btn-primary">Sign In</a>
            </div>
        </div>
    </nav>

    <!-- Restaurant Header -->
    <section class="restaurant-header">
        <div class="container">
            <h1>Our Partner Restaurants</h1>
            <p>Discover amazing food from the best restaurants in your area</p>
        </div>
    </section>

    <!-- Filters -->
    <section class="filters">
        <div class="container">
            <div class="filter-options">
                <button class="filter-btn active" data-cuisine="all">All Cuisines</button>
                <button class="filter-btn" data-cuisine="North Indian">North Indian</button>
                <button class="filter-btn" data-cuisine="South Indian">South Indian</button>
                <button class="filter-btn" data-cuisine="Fast Food">Fast Food</button>
                <button class="filter-btn" data-cuisine="Italian">Italian</button>
                <button class="filter-btn" data-cuisine="Chinese">Chinese</button>
            </div>
            <div class="sort-options">
                <select id="sortSelect">
                    <option value="rating">Sort by Rating</option>
                    <option value="delivery">Delivery Time</option>
                    <option value="name">Name (A-Z)</option>
                </select>
            </div>
        </div>
    </section>

    <!-- Restaurants Grid -->
    <section class="restaurants-section">
        <div class="container">
            <div class="restaurants-grid">
                <% 
                if (restaurants != null && !restaurants.isEmpty()) {
                    for (Restaurant restaurant : restaurants) {
                %>
                <div class="restaurant-card" data-cuisine="<%= restaurant.getCuisineType() %>">
                    <div class="restaurant-image">
                        <img src="<%= restaurant.getImagePath() %>" alt="<%= restaurant.getName() %>">
                        <% if (restaurant.isActive()) { %>
                        <span class="status-badge open">OPEN</span>
                        <% } else { %>
                        <span class="status-badge closed">CLOSED</span>
                        <% } %>
                    </div>
                    <div class="restaurant-content">
                        <h3><%= restaurant.getName() %></h3>
                        <p class="cuisine-type"><%= restaurant.getCuisineType() %></p>
                        <div class="restaurant-meta">
                            <span class="rating">
                                ⭐ <%= String.format("%.1f", restaurant.getRating()) %>
                            </span>
                            <span class="delivery-time">
                                🕒 <%= restaurant.getDeliveryTime() %> min
                            </span>
                        </div>
                        <p class="address">📍 <%= restaurant.getAddress() %></p>
                        <a href="menu?restaurantId=<%= restaurant.getRestaurantId() %>" 
                           class="btn-view-menu">View Menu</a>
                    </div>
                </div>
                <% 
                    }
                } else {
                %>
                <div class="no-restaurants">
                    <h3>No restaurants available at the moment</h3>
                    <p>Please check back later!</p>
                </div>
                <% } %>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
        <div class="container">
            <div class="footer-content">
                <div class="footer-section">
                    <h3>FlavourNest</h3>
                    <p>Your favorite food delivery service</p>
                </div>
                <div class="footer-section">
                    <h4>Company</h4>
                    <ul>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Careers</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </div>
                <div class="footer-section">
                    <h4>Support</h4>
                    <ul>
                        <li><a href="#">Help Center</a></li>
                        <li><a href="#">Safety</a></li>
                        <li><a href="#">Terms</a></li>
                    </ul>
                </div>
            </div>
            <div class="footer-bottom">
                <p>&copy; 2025 FlavorNest. All rights reserved.</p>
            </div>
        </div>
    </footer>

    <script src="Restaurant.js"></script>
</body>
</html>