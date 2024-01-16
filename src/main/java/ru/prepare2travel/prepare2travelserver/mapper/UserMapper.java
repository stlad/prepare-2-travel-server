package ru.prepare2travel.prepare2travelserver.mapper;

import org.mapstruct.Mapper;
import ru.prepare2travel.prepare2travelserver.model.TravelPreset;
import ru.prepare2travel.prepare2travelserver.model.User;
import ru.prepare2travel.prepare2travelserver.model.dto.TravelPresetDTO;
import ru.prepare2travel.prepare2travelserver.model.dto.UserDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    public abstract User fromDto(UserDTO dto);
    public abstract UserDTO toDto(User entity);
    public abstract List<UserDTO> toDto(List<User> entity);
}
