package ru.prepare2travel.prepare2travelserver.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "days")
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long date;

    private Double minTemperature;

    private Double maxTemperature;

    private Double humidity;

    private Integer precipitation;

    private String interesting;
}
