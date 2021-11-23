package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    public void createUser(User user) {
        userDAO.createUser(user);
    }

    public int deleteUser(int id) {
        return userDAO.deleteUser(id);
    }
}
