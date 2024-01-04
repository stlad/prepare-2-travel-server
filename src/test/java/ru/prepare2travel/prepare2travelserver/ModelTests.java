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

    @Test
    @Disabled
    void test(){
        Day d1 = Day.builder().id(1L).build();
        Day d2 = Day.builder().id(2L).build();
        d1 = dayRepository.save(d1);
        d2 = dayRepository.save(d2);

        Item item1 = Item.builder().id(1L).build();
        Item item2 = Item.builder().id(2L).build();
        Item item3 = Item.builder().id(3L).build();
        item1 = itemRepository.save(item1);
        item2 = itemRepository.save(item2);
        item3 = itemRepository.save(item3);

        Travel travel = new Travel();
        travel.setId(1L);
        travel.setItems(List.of(item1,item2,item3));
        travel.setDays(List.of(d1,d2));
        travelRepository.save(travel);

    }

    @Test
    void testasd(){
        Day d1 = Day.builder().id(1L).build();
        Day d2 = Day.builder().id(2L).build();

        Item item1 = Item.builder().id(1L).build();
        Item item2 = Item.builder().id(2L).build();
        Item item3 = Item.builder().id(3L).build();

        Travel travel = new Travel();
        travel.setId(1L);
        travel.setItems(List.of(item1,item2,item3));
        travel.setDays(List.of(d1,d2));
        travelRepository.save(travel);

    }

    @Test
    void a(){
        Travel t = travelRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
        t.getDays().remove(0);
        t = travelRepository.save(t);
        Assertions.assertTrue(true);
    }
}
