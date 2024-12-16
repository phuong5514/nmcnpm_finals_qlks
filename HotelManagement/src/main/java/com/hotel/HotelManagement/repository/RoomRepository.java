package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
