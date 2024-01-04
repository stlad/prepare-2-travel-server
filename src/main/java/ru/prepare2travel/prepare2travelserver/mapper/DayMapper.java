package ru.prepare2travel.prepare2travelserver.mapper;

import org.mapstruct.Mapper;
import ru.prepare2travel.prepare2travelserver.dto.DayDTO;
import ru.prepare2travel.prepare2travelserver.dto.ItemDTO;
import ru.prepare2travel.prepare2travelserver.model.Day;
import ru.prepare2travel.prepare2travelserver.model.Item;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DayMapper {
    public abstract Day fromDto(DayDTO dto);
    public abstract  DayDTO toDto(Day entity);
    public abstract List<DayDTO> toDto(List<Day> entity);
}

