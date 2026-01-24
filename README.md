# 🍽️ FlavorNest – Food Delivery Web Application

<div align="center">

![FlavorNest Logo](assets/images/menu/veg_burger.png)

**Your Favorite Food, Delivered Fast** 🚀

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![JSP](https://img.shields.io/badge/JSP-007396?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/technologies/jspt.html)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)
[![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)]
[![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)]
[![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)]

</div>

---

## 📌 About

**FlavorNest** is a full-stack food delivery web application built using **Java, JSP, Servlets, JDBC, and MySQL** following the **MVC architecture**.  
It enables users to browse restaurants, order food, apply offers, and manage orders through a secure and responsive platform.

---

## ✨ Key Features

- 🔐 Secure user authentication & session management  
- 🍽️ Browse **25+ restaurants** with **100+ menu items**  
- 🛒 Real-time shopping cart with dynamic price calculation  
- 📦 Complete order lifecycle (checkout → confirmation)  
- 🎉 Promotional offers & discount codes  
- 📱 Fully responsive UI (mobile-first design)  

---

## 🛠️ Tech Stack

### Backend
- Java
- JSP & Servlets
- JDBC
- MySQL

### Frontend
- HTML5
- CSS3 (Flexbox & Grid)
- JavaScript (Vanilla)

### Architecture
- MVC (Model–View–Controller)
- DAO Pattern
- Three-Tier Architecture

---

## 🏗️ Architecture Overview

Presentation Layer → JSP / HTML / CSS / JS
Business Layer → Servlets (Controllers)
Data Access Layer → DAO + JDBC
Database Layer → MySQL


---

## 📥 Installation & Setup

### Prerequisites
- Java JDK 8+
- Apache Tomcat 9+
- MySQL 8+
- Eclipse / IntelliJ IDEA
- Git

### Steps

### 💾 Database Design

### 7 normalized relational tables

Indexed queries for performance

Foreign key constraints for data integrity

Key Tables:

1. users
2. restaurants
3. menu
4. orders
5. order_items
6. cart

## 🚀 Usage Flow

1. Register / Login
2. Browse restaurants & menus
3. Add items to cart
4. Apply promo codes
5. Checkout & place order
6. View order confirmation

# 📁 Project Structure

FlavorNest/
│
├── src/
│   └── com/
│       └── food/
│           ├── Servlet/
│           │   ├── HomeServlet.java
│           │   ├── UserLoginServlet.java
│           │   ├── UserRegisterServlet.java
│           │   ├── MenuServlet.java
│           │   ├── CartServlet.java
│           │   └── CheckoutServlet.java
│           │
│           ├── dao/
│           │   ├── UserDAO.java
│           │   ├── RestaurantDAO.java
│           │   ├── MenuDAO.java
│           │   ├── OrderDAO.java
│           │   └── OrderItemDAO.java
│           │
│           ├── daoimplementation/
│           │   ├── UserDAOImpl.java
│           │   ├── RestaurantDAOImpl.java
│           │   ├── MenuDAOImpl.java
│           │   ├── OrderDAOImpl.java
│           │   └── OrderItemDAOImpl.java
│           │
│           ├── model/
│           │   ├── User.java
│           │   ├── Restaurant.java
│           │   ├── Menu.java
│           │   ├── Order.java
│           │   ├── OrderItem.java
│           │   ├── Cart.java
│           │   └── CartItem.java
│           │
│           └── utility/
│               └── DBConnection.java
│
├── WebContent/
│   ├── WEB-INF/
│   │   ├── web.xml
│   │   └── lib/
│   │       └── mysql-connector-java-x.x.xx.jar
│   │
│   ├── assets/
│   │   └── images/
│   │       └── menu/
│   │           ├── flavour.png
│   │           ├── veg_burger.jpg
│   │           ├── cheese_pizza.jpg
│   │           └── [other food images]
│   │
│   ├── home.html
│   ├── login.html
│   ├── register.html
│   ├── menu.html
│   ├── offers.html
│   ├── Restaurant.jsp
│   ├── Cart.jsp
│   ├── checkout.jsp
│   ├── orderConfirmation.html
│   │
│   ├── common.css
│   ├── homeStyle.css
│   ├── UloginStyle.css
│   ├── URegisterStyle.css
│   ├── menuStyle.css
│   ├── Restaurant.css
│   ├── cartStyle.css
│   ├── checkoutStyle.css
│   ├── offersStyle.css
│   ├── orderConfirmationStyle.css
│   │
│   ├── script.js
│   ├── menu.js
│   └── Restaurant.js
│
├── database_schema.sql
├── README.md
└── .gitignore


### 🔒 Security Features

1. PreparedStatements (SQL Injection prevention)
2. Secure HttpSession handling
3. Role-based access control
4. Input validation & sanitization
5. HttpOnly cookies

### 🚀 Future Enhancements
### Planned Features

• Real-time order tracking with WebSockets
• Payment gateway integration (Razorpay/Stripe)
• Email notifications for order updates
• SMS notifications via Twilio
• Admin dashboard for restaurant management
• User reviews and ratings system
• Favorite restaurants and items
• Order history with reorder option
• Advanced search with filters
• Geolocation-based restaurant suggestions
• Multi-language support
• Dark mode toggle
• PWA (Progressive Web App) support

### Technical Improvements

 • Implement connection pooling
 • Add caching layer (Redis)
 • RESTful API development
 • Unit testing with JUnit
 • Integration testing
 • CI/CD pipeline setup
 • Docker containerization
 • Microservices architecture
 • Load balancing
 • CDN integration for static assets

 ### 📝 License
This project is licensed under the MIT License - see the LICENSE file for details.
MIT License

Copyright (c) 2025 FlavorNest

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction...

### 👨‍💻 Author

## Rangaswamy Gari Nagesh

## GitHub: https://github.com/nageshgithub3

## LinkedIn: https://linkedin.com/in/nageshlnkdin

## Email: nageshkanna362@gmail.com

### 🙏 Acknowledgments

 🎀 Inspired by food delivery platforms like Swiggy and Zomato
 🎀 Food images from Unsplash
 🎀 Icons and emojis from Unicode Emoji
 🎀 UI/UX inspiration from modern web design trends

 ## ⭐ Support

If you found this project helpful, please star ⭐ the repository.

Made with ❤️ using Java


---

If you want next, I can:
- ✅ Replace placeholders with **your real GitHub name**
- ✅ Create a **short README (recruiter version)**
- ✅ Optimize it for **Spring Boot upgrade**
- ✅ Write a **LinkedIn project post** from this

Just tell me 👍




