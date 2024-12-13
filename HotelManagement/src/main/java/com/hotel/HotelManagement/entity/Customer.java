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
//    @Column(name = "RoleName", length = 20, nullable = false)
//    private String roleName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CustomerId", nullable = false)
    private int customerId;

    @Column(name = "IdentityCard", length = 45 ,nullable = false)
    private String identityCard;

    @Column(name = "CustomerName", length = 45, nullable = false)
    private String customerName;

    @Column(name = "Address", nullable = true)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = CustomerType.class)
    @JoinColumn(name = "CustomerTypeID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CustomerType cutomerType;



}
