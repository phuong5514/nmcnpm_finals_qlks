package com.hotel.HotelManagement.repository;

import com.hotel.HotelManagement.entity.RevenueReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface RevenueReportRepository extends JpaRepository<RevenueReport, Integer> {
    @Query("Select i from RevenueReport i where MONTH(i.month) = MONTH(:_month) AND YEAR(i.month) = YEAR(:_month)")
    RevenueReport findRevenueReportByMonth(@Param("_month") Date month);
}
