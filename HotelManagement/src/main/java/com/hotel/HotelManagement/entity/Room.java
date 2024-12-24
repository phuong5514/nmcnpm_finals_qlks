package com.hotel.HotelManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Room")
public class Room {
    @Id
    @Column(name = "RoomID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;

    @Column(name = "Status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.VACANT;

    public enum Status {
        VACANT,
        OCCUPIED,
        BOOKED
    }

    @Column(name = "RoomTypeName", nullable = false)
    private String roomTypeName;

    @Column(name = "MaxGuestCount", nullable = false)
    private int maxGuestCount;


}
