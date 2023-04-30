package com.example.Microservice.service;

import com.example.Microservice.entity.Statistics;
import com.example.Microservice.models.StatisticsDto;
import com.example.Microservice.models.StatisticsDtoWithAverage;
import com.example.Microservice.repository.StatisticsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class StatisticsService {
    StatisticsRepo statisticsRepo;

    private StatisticsDto mapToDto(Statistics statistics){
       return new StatisticsDto(statistics.getDate(),
                statistics.getViews(),
                statistics.getClicks(),
                statistics.getCost());
    }

    private StatisticsDtoWithAverage mapToDtoAverage(Statistics statistics){
        return new StatisticsDtoWithAverage(statistics.getDate(),
                statistics.getViews(),
                statistics.getClicks(),
                statistics.getCost(),
                statistics.getCpc(),
                statistics.getCpm());
    }


    public Long create(Statistics statistics, Integer views, Integer clicks, Integer cost){
        mapToDto(statistics);
        return statisticsRepo.save(statistics).getId();
    }

    public StatisticsDtoWithAverage findStatisticsByDate(LocalDate date){
        Statistics statistics = statisticsRepo.findByDate(date);
        statistics.setCpm(statistics.getCost()/statistics.getClicks());
        statistics.setCpm(statistics.getCost()/statistics.getViews()*1000);
        return mapToDtoAverage(statistics);
    }

    public void deleteStatisticsById(Long id){
        statisticsRepo.deleteById(id);
    }
}
