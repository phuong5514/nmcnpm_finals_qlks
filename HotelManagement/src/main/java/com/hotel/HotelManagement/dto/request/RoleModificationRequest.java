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
public class RoleModificationRequest {
    @NotBlank(message = "role name cannot be blank")
    private String roleName;

    @NotBlank(message = "role id cannot be blank")
    private String roleId;
}
