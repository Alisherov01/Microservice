package com.example.Microservice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy:MM:dd")
    private LocalDate date;

    @Column()
    private Double views;

    @Column()
    private Double clicks;

    @Column()
    private Double cost;

    private Double cpc;

    private Double cpm;
}
