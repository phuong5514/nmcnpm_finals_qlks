package com.hotel.HotelManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.Month;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "`RevenueReport`")
public class RevenueReport {
    @Id
    @Column(name = "RevenueReportID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int revenueReportID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = RoomType.class)
    @JoinColumn(name = "RoomTypeName", nullable = false)
    private RoomType roomType;

    @Column(name = "Month", nullable = false)
    private Date month;

    @Column(name = "Revenue", nullable = false)
    private int revenue;

    @Column(name = "Percentage", precision = 2, nullable = false)
    private double percentage;
}
