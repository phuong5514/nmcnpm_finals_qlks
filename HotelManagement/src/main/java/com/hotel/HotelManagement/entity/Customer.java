package com.hotel.HotelManagement.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`Customer`")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId", nullable = false)
    private int customerId;

    @Column(name = "IdentityCard", length = 45 ,nullable = false, unique = true)
    private String identityCard;

    @Column(name = "CustomerName", length = 45, nullable = false)
    private String customerName;

    @Column(name = "Address", length = 45, nullable = true)
    private String address;

    @Column(name = "CustomerTypeID", length = 3, nullable = false)
    private String customerTypeID;
}
