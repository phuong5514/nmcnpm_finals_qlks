package com.hotel.HotelManagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InvoiceCreationOrUpdateRequest {
    private int InvoiceId;
    private int CustomerId;
    private Date IssuedDate;
    private int TotalAmount;
}
