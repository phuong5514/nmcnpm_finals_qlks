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
@Table(name = "`RoomType`")
public class RoomType {
    @Id
    @Column(name = "RoomTypeName", nullable = false)
    private String roomTypeName;

    @Column(name = "BasePrice", nullable = false)
    private int basePrice;

    @Column(name = "OverGuestRate", precision = 2, nullable = false)
    private double overGuestRate;
}
