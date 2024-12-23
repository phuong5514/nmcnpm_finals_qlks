package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.RoomType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoomTypeService {
    List<RoomType> getAllRoomTypes();
    List<RoomType> findRoomTypesByName(String roomTypeName);
    RoomType findRoomTypeByName(String roomTypeName);

    RoomType save(RoomType roomType);
    void delete(RoomType roomType);
    void delete(String roomTypeName);
}
