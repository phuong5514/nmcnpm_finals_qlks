package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, String> {
}
