package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.Regulation;
import com.hotel.HotelManagement.repository.RegulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegulationService implements IRegulationService {
    @Autowired
    private RegulationRepository regulationRepository;

    @Override
    public Regulation getRegulation() {
        return regulationRepository.getRegulationByLock("X");
    }

    @Override
    public Regulation saveRegulation(Regulation regulation) {
        if (!regulation.getLock().equals("X")) {
            regulation.setLock("X");
        }
        return regulationRepository.save(regulation);
    }
}
