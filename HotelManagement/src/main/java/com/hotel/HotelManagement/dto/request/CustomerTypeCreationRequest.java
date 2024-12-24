package com.hotel.HotelManagement.dto.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerTypeCreationRequest {

    @NotBlank(message = "customer type must have a name")
    private String customerTypeName;

    @PositiveOrZero(message = "Fee modifier must be zero or a positive value.")
    private double feeModifier;
}
