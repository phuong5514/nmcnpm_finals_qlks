package com.hotel.HotelManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "Regulaion")
public class Regulation {
    @Id
    @Column(name = "Lock", nullable = false)
    private String lock;

    @Column(name = "MaxGuestCount", nullable = false)
    private int defaultMaxGuestCount;

    @Column(name = "OverGuestRate", precision = 2, nullable = false)
    private double defaultOverGuestRate;
}
