package com.hotel.HotelManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`CustomerType`")
public class CustomerType {
    @Id
    @Column(name = "CustomerTypeID", length = 3, nullable = false)
    private String customerTypeID;

    @Column(name = "CustomerTypeName", length = 20, nullable = false, unique = true)
    private String customerTypeName;

    @Column(name = "FeeModifier", precision = 2, nullable = false)
    private double feeModifier;

}
