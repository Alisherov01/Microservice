package com.example.Microservice.controller;

import com.example.Microservice.entity.Statistics;
import com.example.Microservice.models.StatisticsDto;
import com.example.Microservice.models.StatisticsDtoWithAverage;
import com.example.Microservice.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class StatisticsController {
    StatisticsService statisticsService;

    @PostMapping("/statistics/create")
    public Long createNewStatistics (@RequestBody Statistics statistics,
                                     @RequestParam(required = false) Integer views,
                                     @RequestParam(required = false) Integer clicks,
                                     @RequestParam(required = false) Integer cost){
        return  statisticsService.create(statistics,views,clicks,cost);
    }


    @GetMapping("/statistics/getByDate")
    public StatisticsDtoWithAverage getByDate(@RequestParam (required = false) LocalDate date){
        return statisticsService.findStatisticsByDate(date);
    }

    @DeleteMapping("/statistics/delete")
    void deleteStatisticsById(@PathVariable Long id){
        statisticsService.deleteStatisticsById(id);
    }
}
