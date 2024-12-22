package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.RoomType;
import com.hotel.HotelManagement.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService implements IRoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    @Override
    public List<RoomType> findRoomTypesByName(String roomTypeName) {
        return roomTypeRepository.findRoomTypesByRoomTypeNameContaining(roomTypeName);
    }

    @Override
    public RoomType save(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public void delete(RoomType roomType) {
        roomTypeRepository.delete(roomType);
    }
}
