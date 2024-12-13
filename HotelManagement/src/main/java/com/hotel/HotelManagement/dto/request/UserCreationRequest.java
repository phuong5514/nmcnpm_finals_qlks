package com.hotel.HotelManagement.dto.request;

import com.hotel.HotelManagement.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequest {
    private String username;
    private String password;
    private List<String> roles;

}
