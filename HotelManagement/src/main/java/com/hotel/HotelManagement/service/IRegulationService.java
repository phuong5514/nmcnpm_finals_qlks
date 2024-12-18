package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.Regulation;
import org.springframework.stereotype.Service;

@Service
public interface IRegulationService {
    Regulation getRegulation();
    Regulation saveRegulation(Regulation regulation);
}
