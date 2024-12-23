package com.hotel.HotelManagement.dto.request;

import com.hotel.HotelManagement.entity.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
