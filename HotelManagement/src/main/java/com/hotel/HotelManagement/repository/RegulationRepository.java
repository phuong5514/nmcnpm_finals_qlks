package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.Regulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegulationRepository extends JpaRepository<Regulation, String> {
    Regulation getRegulationByLock(String lock);
}
