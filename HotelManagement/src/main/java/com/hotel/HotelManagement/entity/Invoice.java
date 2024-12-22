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

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class, optional = false)
    @JoinColumn(name = "CustomerID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer Customer;

    @Column(name = "IssuedDate", nullable = false)
    private Date IssuedDate;

    @Column(name = "TotalAmount", nullable = false)
    private int TotalAmount;
}
