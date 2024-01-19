package ru.prepare2travel.prepare2travelserver.model.dto;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class TravelDTO {
    private Long id;
    private String country;
    private String region;
    private String city;
    private List<DayDTO> days;
    private List<ItemDTO> items;
    private Long creationDate;
    private Long ownerId;
}
