package com.hotel.HotelManagement.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDeletionRequest {
    @NotNull(message = "user id cannot be null")
    @Min(value = 0, message = "user id need to be a positive number")
    private Integer userID;
}
