package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.Regulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegulationRepository extends JpaRepository<Regulation, String> {
}
