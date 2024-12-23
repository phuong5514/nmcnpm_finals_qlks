package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoleService {
    List<Role> getRoles();

    Role findByRolename(String rolename);

    Role findById(String id);

    Role save(Role role);
    void delete(Role role);
    void delete(String id);
}
