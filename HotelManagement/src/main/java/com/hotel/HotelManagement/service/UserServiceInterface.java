package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceInterface {
    List<User> getUsers();
    User findByUsername(String username);

    User findById(Integer id);

    User save(User user);
    void deleteUser(User user);
}
