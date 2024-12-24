package com.hotel.HotelManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`UsageReport`")
public class UsageReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsageReportID", nullable = false)
    private int usageReportID;

    @Column(name = "RoomID", nullable = false)
    private int roomID;

    @Column(name = "Month", nullable = false)
    private java.sql.Date month;

    @Column(name = "DaysUsed", nullable = false)
    private int daysUsed;

    @Column(name = "UsageRate", nullable = false, precision = 2)
    private double usageRate;
}
