package com.hotel.HotelManagement.dto.request;

import jakarta.validation.constraints.Min;
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
public class InvoiceCreationRequest {
//    @NotNull(message = "Invoice ID must not be null.")
//    @Min(value = 1, message = "Invoice ID must be a positive number.")
//    private int InvoiceId;

    @NotNull(message = "Customer ID must not be null.")
    @Min(value = 1, message = "Customer ID must be a positive number.")
    private Integer customerId;

    @NotNull(message = "Issued Date must not be null.")
    private Date issuedDate;

    @NotNull(message = "Total Amount must not be null.")
    @Min(value = 0, message = "Total Amount must be 0 or a positive number.")
    private Integer totalAmount;
}
