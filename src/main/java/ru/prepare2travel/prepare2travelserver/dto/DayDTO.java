package ru.prepare2travel.prepare2travelserver.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class DayDTO {
    private Long id;
    private LocalDateTime date;
    private Double temperature;
    private Integer precipitationChance;
    private String interesting;
}
