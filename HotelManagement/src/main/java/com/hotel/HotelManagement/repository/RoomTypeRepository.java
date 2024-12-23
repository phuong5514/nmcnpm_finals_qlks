package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, String> {
    List<RoomType> findRoomTypesByRoomTypeNameContaining(String roomTypeName);
}
