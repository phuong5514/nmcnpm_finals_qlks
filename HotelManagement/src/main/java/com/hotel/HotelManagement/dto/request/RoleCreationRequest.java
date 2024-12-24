package com.hotel.HotelManagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleCreationRequest {
    @NotBlank(message = "role name cannot be blank")
    private String roleName;
}
