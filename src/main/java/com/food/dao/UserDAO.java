package com.food.dao;

import com.food.model.User;
import java.util.List;

public interface UserDAO {
    int registerUser(User user);
    User loginUser(String email, String password);
    User getUserById(int userId);
    List<User> getAllUsers();
    int updateUser(User user);
    int deleteUser(int userId);
    User getUserByEmail(String email);
}