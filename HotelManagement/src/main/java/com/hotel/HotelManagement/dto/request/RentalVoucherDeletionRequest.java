package com.hotel.HotelManagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class RentalVoucherDeletionRequest {
    private int rentalVoucherId;
}