package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.UsageReport;
import com.hotel.HotelManagement.repository.UsageReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class UsageReportService implements IUsageReportService {
    @Autowired
    UsageReportRepository usageReportRepository;

    @Override
    public List<UsageReport> getUsageReports() {
        return usageReportRepository.findAll();
    }

    @Override
    public UsageReport getUsageReport(int id) {
        return usageReportRepository.getUsageReportByUsageReportID(id);
    }

    @Override
    public List<UsageReport> getUsageReports(Date month) {
        return usageReportRepository.findUsageReportsByMonth(month);
    }

    @Override
    public UsageReport getUsageReport(Date month, Integer roomId) {
        return usageReportRepository.findUsageReportsByMonthAndRoomID(month, roomId);
    }

    @Override
    public UsageReport save(UsageReport usageReport) {
        return usageReportRepository.save(usageReport);
    }

    @Override
    public void delete(UsageReport usageReport) {
        usageReportRepository.delete(usageReport);
    }

    @Override
    public void delete(int id) {
        usageReportRepository.delete(getUsageReport(id));
    }
}
