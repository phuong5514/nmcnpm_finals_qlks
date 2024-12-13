package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.dto.request.UserCreationRequest;
import com.hotel.HotelManagement.entity.Role;
import com.hotel.HotelManagement.entity.User;
import com.hotel.HotelManagement.repository.RoleRepository;
import com.hotel.HotelManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserServiceInterface{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User createRequest(UserCreationRequest request){
        User user = new User();

        // Gán username và mã hóa mật khẩu
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        Set<Role> roles = request.getRoles().stream()
                .map(roleName -> roleRepository.findByRoleName(roleName)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
                .collect(Collectors.toSet());

        // Gán roles cho user
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
