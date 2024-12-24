package com.hotel.HotelManagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerModificationRequest {
    private int customerId;

    @NotBlank(message = "Identity card cannot be blank")
    private String identityCard;

    @NotBlank(message = "Customer name cannot be blank")
    private String customerName;

    @NotBlank(message = "Customer address cannot be blank")
    private String address;

    @NotBlank(message = "Customer must be of one type")
    private String cutomerTypeString;

}
