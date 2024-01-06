package ru.prepare2travel.prepare2travelserver;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.prepare2travel.prepare2travelserver.model.Day;
import ru.prepare2travel.prepare2travelserver.model.Item;
import ru.prepare2travel.prepare2travelserver.model.Travel;
import ru.prepare2travel.prepare2travelserver.repository.DayRepository;
import ru.prepare2travel.prepare2travelserver.repository.ItemRepository;
import ru.prepare2travel.prepare2travelserver.repository.TravelRepository;

import java.util.List;

@SpringBootTest
public class ModelTests {
    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private DayRepository dayRepository;



}
