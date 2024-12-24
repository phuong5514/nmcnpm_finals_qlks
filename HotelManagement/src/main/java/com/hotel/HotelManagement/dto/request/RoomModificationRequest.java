package com.hotel.HotelManagement.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RoomModificationRequest {
    @NotNull( message = "room id cannot be null")
    @Min(value = 0, message = "room id must be a positive number")
    private int roomId;

    @NotBlank(message = "room type cannot be blank")
    private String roomTypeString;

    @NotNull(message = "max guest cannot be null")
    @Min(value = 1, message = "at least 1 guest can accomidate the room")
    private int maxGuestCount;

    @NotNull(message = "over guest rate cannot be null")
    @Min(value = 0, message = "over guest rate must be a positive number")
    private double overGuestRate;
}
