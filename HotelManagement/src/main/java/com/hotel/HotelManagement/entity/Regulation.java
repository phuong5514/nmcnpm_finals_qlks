package com.hotel.HotelManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


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



//    MaxGuestCount		int,
//    OverGuestRate	decimal(5,2),
//	--IntlVisitorRate	decimal(5,2), //** Xem table CustomerType **//
//
//
//	--https://stackoverflow.com/questions/3967372/how-to-constrain-a-table-to-contain-a-single-row
//    Lock char(1) not null DEFAULT 'X',
//    constraint PK_T1 PRIMARY KEY (Lock),
//    constraint CK_T1_Locked CHECK (Lock='X')
}
