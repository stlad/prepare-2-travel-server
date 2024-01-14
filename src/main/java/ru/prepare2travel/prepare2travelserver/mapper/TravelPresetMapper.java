package ru.prepare2travel.prepare2travelserver.mapper;


import org.mapstruct.Mapper;
import ru.prepare2travel.prepare2travelserver.model.TravelPreset;
import ru.prepare2travel.prepare2travelserver.model.dto.TravelPresetDTO;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = { ItemMapper.class, DayMapper.class })
public interface TravelPresetMapper {
    public abstract TravelPreset fromDto(TravelPresetDTO dto);
    public abstract TravelPresetDTO toDto(TravelPreset entity);
    public abstract List<TravelPresetDTO> toDto(List<TravelPreset> entity);
}
