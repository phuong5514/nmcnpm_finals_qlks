package com.hotel.HotelManagement.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class RoomCreationRequest {
    @NotBlank(message = "room type cannot be blank")
    private String roomTypeString;

    @Min(value = 1, message = "at least 1 guest can accomidate the room")
    private Integer maxGuestCount;
}
