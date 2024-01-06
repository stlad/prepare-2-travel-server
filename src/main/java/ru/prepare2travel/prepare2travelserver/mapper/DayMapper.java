package ru.prepare2travel.prepare2travelserver.mapper;

import org.mapstruct.Mapper;
import ru.prepare2travel.prepare2travelserver.model.dto.DayDTO;
import ru.prepare2travel.prepare2travelserver.model.Day;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DayMapper {
    public abstract Day fromDto(DayDTO dto);
    public abstract  DayDTO toDto(Day entity);
    public abstract List<DayDTO> toDto(List<Day> entity);
}

