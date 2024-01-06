package ru.prepare2travel.prepare2travelserver.mapper;

import org.mapstruct.Mapper;
import ru.prepare2travel.prepare2travelserver.model.dto.TravelDTO;
import ru.prepare2travel.prepare2travelserver.model.Travel;

import java.util.List;

@Mapper(componentModel = "spring",
    uses = { ItemMapper.class, DayMapper.class })

public interface TravelMapper {
    public abstract Travel fromDto(TravelDTO dto);
    public abstract  TravelDTO toDto(Travel entity);
    public abstract List<TravelDTO> toDto(List<Travel> entity);
}
