package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.RevenueReport;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface IRevenueReportService {
    List<RevenueReport> getRevenueReport();

    RevenueReport getRevenueReportById(int id);
    RevenueReport getRevenueReportByMonth(Date month);

    RevenueReport addRevenueReport(RevenueReport report);
    RevenueReport updateRevenueReport(RevenueReport report);
    RevenueReport deleteRevenueReport(int id);
}
