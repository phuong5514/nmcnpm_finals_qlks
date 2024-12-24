package com.hotel.HotelManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`Invoice`")
public class Invoice {
    @Id
    @Column(name = "InvoiceId")
    private int InvoiceId;

    @Column(name = "CustomerId", nullable = false)
    private int customerId;

    @Column(name = "IssuedDate", nullable = false)
    private Date IssuedDate;

    @Column(name = "TotalAmount", nullable = false)
    private int TotalAmount;
}
