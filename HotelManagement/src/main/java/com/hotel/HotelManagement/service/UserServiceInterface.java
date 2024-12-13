package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.User;

import java.util.Optional;

public interface UserServiceInterface {
    User findByUsername(String username);
}
