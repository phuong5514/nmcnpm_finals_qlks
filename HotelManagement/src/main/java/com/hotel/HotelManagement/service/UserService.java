package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.dto.request.UserCreationRequest;
import com.hotel.HotelManagement.dto.request.UserDeletionRequest;
import com.hotel.HotelManagement.dto.request.UserModificationRequest;
import com.hotel.HotelManagement.entity.Role;
import com.hotel.HotelManagement.entity.User;
import com.hotel.HotelManagement.repository.RoleRepository;
import com.hotel.HotelManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User createRequest(UserCreationRequest request){
        User user = new User();
        modifyUser(user, request.getUsername(), request.getPassword(), request.getRoles());
        return save(user);
//        return userRepository.save(user);
    }

    public User updateRequest(UserModificationRequest request){
        User user = findById(request.getUserID());
        if (user == null) {
            user = new User();
        }
        modifyUser(user, request.getUsername(), request.getPassword(), request.getRoles());
        return save(user);
    }

    private void modifyUser(User user, String username, String password, List<String> roles) {
        // Gán username và mã hóa mật khẩu
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        Set<Role> rolesList = roles.stream()
                .map(roleName -> roleRepository.findByRoleName(roleName)
                        .orElseThrow(() -> new RuntimeException("Role not found: " + roleName)))
                .collect(Collectors.toSet());

        // Gán roles cho user
        user.setRoles(rolesList);
    }


    public boolean deleteRequest(UserDeletionRequest request)
    {
        User user = findById(request.getUserID());
        if (user == null) {
            return false;
        } else {
            deleteUser(user);
            return true;
        }
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
