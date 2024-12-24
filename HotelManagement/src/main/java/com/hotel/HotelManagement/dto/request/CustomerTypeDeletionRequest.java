package com.hotel.HotelManagement.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CustomerTypeDeletionRequest {

    @NotBlank(message = "Customer type ID must not be blank.")
    private String customerTypeID;
}
