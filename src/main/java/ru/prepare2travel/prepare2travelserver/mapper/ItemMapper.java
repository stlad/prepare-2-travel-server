package ru.prepare2travel.prepare2travelserver.mapper;

import org.mapstruct.Mapper;
import ru.prepare2travel.prepare2travelserver.model.dto.ItemDTO;
import ru.prepare2travel.prepare2travelserver.model.Item;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    public abstract  Item fromDto(ItemDTO dto);
    public abstract  ItemDTO toDto(Item entity);
    public abstract List<ItemDTO> toDto(List<Item> entity);

}
