package com.hotel.HotelManagement.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RentalVoucherDeletionRequest {
    @NotNull(message = "id cannot be null")
    private int rentalVoucherId;
}
