package ru.prepare2travel.prepare2travelserver.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class TravelPresetDTO {
    private Long id;
    private String name;
    private List<ItemDTO> itemsPerTravel;
    private List<ItemDTO> itemsPerDay;
}
