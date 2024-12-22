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
@Table(name = "`RentalVoucher`")
public class RentalVoucher {
    @Id
    @Column(name = "VoucherId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voucherId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class, optional = false)
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Room.class, optional = false)
    @JoinColumn(name = "RoomID", nullable = false)
    private Room room;

    @Column(name = "StartDate", nullable = false)
    private Date startDate;

    @Column(name = "Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    public enum Status {
        PENDING,
        PAID
    }
}
