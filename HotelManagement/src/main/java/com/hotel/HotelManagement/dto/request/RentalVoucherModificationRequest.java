package com.hotel.HotelManagement.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RentalVoucherModificationRequest {
    @NotNull(message = "voucher id cannot be null")
    @Min(value = 0, message = "voucher id must be positive")
    private int voucherId;

    @NotNull(message = "customer id cannot be null")
    @Min(value = 0, message = "customer id must be positive")
    private int customerId;

    @NotNull(message = "room id cannot be null")
    @Min(value = 0, message = "room id must be positive")
    private int roomId;

    @NotNull(message = "start date cannot be null")
    private Date startDate;


}
