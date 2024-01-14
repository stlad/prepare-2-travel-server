package ru.prepare2travel.prepare2travelserver.model.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class DayDTO {
    private Long id;
    private LocalDateTime date;
    private Double temperature;
    private Integer precipitation;
    private String interesting;
    private Double minTemperature;
    private Double maxTemperature;
}
