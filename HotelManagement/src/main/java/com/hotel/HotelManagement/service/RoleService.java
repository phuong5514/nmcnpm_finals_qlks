package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.dto.request.RoleCreationRequest;
import com.hotel.HotelManagement.dto.request.RoleDeletionRequest;
import com.hotel.HotelManagement.dto.request.RoleModificationRequest;
import com.hotel.HotelManagement.entity.Role;
import com.hotel.HotelManagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findByRolename(String rolename) {
        return roleRepository.findByRoleName(rolename).orElse(null);
    }

    @Override
    public Role findById(String id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }

    public Role createRequest(RoleCreationRequest request) {
        String roleName = request.getRoleName();
        if (roleRepository.findByRoleName(roleName).isPresent()) {
            return null;
        }

        Role role = new Role();
        role.setRoleName(roleName);
        return roleRepository.save(role);
    }

    public Role modifyRequest(RoleModificationRequest request) {
        String roleName = request.getRoleName();
        String roleId = request.getRoleId();

        Role role = findById(roleId);
        if (role == null) {
            return null;
        }

        Role roleWithName = findByRolename(roleName);
        if (roleWithName == null || roleWithName.getRoleID().equals(roleId)) {
            role.setRoleName(roleName);
            save(role);
        }

        return null;
    }

    public boolean deleteRequest(RoleDeletionRequest request) {
        String roleId = request.getRoleId();
        Role role = findById(roleId);
        if (role == null) {
            return false;
        }
        roleRepository.delete(role);
        return true;
    }
}
