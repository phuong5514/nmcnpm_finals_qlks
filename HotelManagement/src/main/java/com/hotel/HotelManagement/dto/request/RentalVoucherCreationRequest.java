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
public class RentalVoucherCreationRequest {

    @NotBlank(message = "customer Id cannot be blank")
    private int customerId;

    @NotNull(message = "room id cannot be null")
    @Min(value = 0, message = "room id must be positive")
    private int roomId;

    @NotNull(message = "start date cannot be null")
    private Date startDate;
}
