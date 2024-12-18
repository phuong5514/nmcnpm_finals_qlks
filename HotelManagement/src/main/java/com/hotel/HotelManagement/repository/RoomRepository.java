package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.Room;
import com.hotel.HotelManagement.entity.RoomType;
import jakarta.persistence.Enumerated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query("SELECT i from Room i where i.status = :status")
    List<Room> findRoomsByRoomStatus(String status);

    List<Room> findRoomsByRoomIdContaining(int roomId);

    List<Room> getRoomsByRoomType(RoomType roomType);
}
