package com.hotel.HotelManagement.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomTypeCreationRequest {
    @NotBlank(message = "room type name cannot be blank")
    private String roomTypeName;

    @NotNull(message = "room base price cannot be null")
    @Min(value = 1, message = "room base price must be a positive number")
    private int basePrice;

    @Min(value = 0, message = "over guest rate must be a positive number")
    private double overGuestRate;
}
