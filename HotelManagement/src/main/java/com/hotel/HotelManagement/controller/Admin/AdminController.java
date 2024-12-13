package com.hotel.HotelManagement.controller.Admin;

import com.hotel.HotelManagement.dto.request.UserCreationRequest;
import com.hotel.HotelManagement.entity.User;
import com.hotel.HotelManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @RequestMapping
    public String adminPage(Model model) {
        List<User> users = userService.getUsers(); // Lấy danh sách người dùng từ database
        model.addAttribute("users", users); // Đưa danh sách người dùng vào model
        return "admin/admin";
    }

    @PostMapping("/create-user")
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createRequest(request);
    }



}
