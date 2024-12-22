package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomTypeRepository extends JpaRepository<RoomType, String> {
    List<RoomType> findRoomTypesByRoomTypeNameContaining(String roomTypeName);
}
