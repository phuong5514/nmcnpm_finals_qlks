package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.UsageReport;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface IUsageReportService {
    List<UsageReport> getUsageReports();
    UsageReport getUsageReport(int id);
    List<UsageReport> getUsageReports(Date month);
    UsageReport getUsageReport(Date month, Integer roomId);

    UsageReport save(UsageReport usageReport);
    void delete(UsageReport usageReport);
    void delete(int id);
}
