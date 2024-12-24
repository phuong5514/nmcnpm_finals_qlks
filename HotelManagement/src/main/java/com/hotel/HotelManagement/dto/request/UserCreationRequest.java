package com.hotel.HotelManagement.dto.request;

import com.hotel.HotelManagement.entity.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "username cannot be blank")
    private String username;
    @NotBlank(message = "password cannot be blank")
    private String password;

    @NotNull(message = "roles list cannot be null")
    @NotEmpty(message = "user need to have at least 1 role")
    private List<String> roles;

}
