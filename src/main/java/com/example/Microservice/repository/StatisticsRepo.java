package com.example.Microservice.repository;

import com.example.Microservice.entity.Statistics;
import com.example.Microservice.models.StatisticsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StatisticsRepo extends JpaRepository<Statistics,Long> {

    @Query(value = "select * from statistics where date = ?", nativeQuery = true)
    Statistics findByDate(LocalDate date);
}
