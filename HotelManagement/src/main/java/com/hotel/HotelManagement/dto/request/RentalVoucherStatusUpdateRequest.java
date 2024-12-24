package com.hotel.HotelManagement.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RentalVoucherStatusUpdateRequest {
    @NotNull(message = "voucher id cannot be null")
    @Min(value = 0, message = "voucher id must be positive")
    private int voucherId;

    @NotBlank(message = "status string cannot be blank")
    private String statusString;
}
