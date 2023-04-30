package com.example.Microservice.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsDtoWithAverage {
    private LocalDate date;

    private Double views;

    private Double clicks;

    private Double cost;

    private Double cpc;

    private Double cpm;
}
