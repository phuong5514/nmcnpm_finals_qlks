package com.hotel.HotelManagement.service;

import com.hotel.HotelManagement.entity.RevenueReport;
import com.hotel.HotelManagement.repository.RevenueReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class RevenueReportService implements IRevenueReportService{

    @Autowired
    private RevenueReportRepository repo;

    @Override
    public List<RevenueReport> getRevenueReport() {
        return repo.findAll();
    }

    @Override
    public RevenueReport getRevenueReportById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public RevenueReport getRevenueReportByMonth(Date month) {
        return repo.findRevenueReportByMonth(month);
    }

    @Override
    public RevenueReport save(RevenueReport report) {
        return repo.save(report);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(RevenueReport report) {
        repo.delete(report);
    }
}
