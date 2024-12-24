package com.hotel.HotelManagement.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RoomDeletionRequest {
    @NotNull(message = "room id cannot be null")
    @Min(value = 0, message = "room id must be a positive number")
    private int roomId;
}
