package ru.prepare2travel.prepare2travelserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.prepare2travel.prepare2travelserver.model.Day;
import ru.prepare2travel.prepare2travelserver.model.Item;
import ru.prepare2travel.prepare2travelserver.model.Travel;
import ru.prepare2travel.prepare2travelserver.model.TravelPreset;
import ru.prepare2travel.prepare2travelserver.model.dto.UserDTO;
import ru.prepare2travel.prepare2travelserver.repository.TravelPresetRepository;
import ru.prepare2travel.prepare2travelserver.repository.TravelRepository;
import ru.prepare2travel.prepare2travelserver.service.TravelService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.prepare2travel.prepare2travelserver.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static ru.prepare2travel.prepare2travelserver.config.DataGenerator.getCyclingPreset;

@Configuration
@Slf4j
public class DataLoadingConfig {

    @Autowired
    private TravelRepository travelRepository;

    @ConditionalOnProperty(
            prefix = "command-line-runner.data-loading.travels",
            value = "enabled",
            havingValue = "true",
            matchIfMissing = false)
    @Bean
    public CommandLineRunner dataLoader(TravelRepository travelRepository) {
        return args -> {
           log.info("Loading Test Travels ...");

            Day d1 = Day.builder().id(1L).build();
            Day d2 = Day.builder().id(2L).build();
            Day d3 = Day.builder().id(3L).build();
            Day d4 = Day.builder().id(4L).build();
            Day d5 = Day.builder().id(5L).build();


            Item item1 = Item.builder().id(1L).build();
            Item item2 = Item.builder().id(2L).build();
            Item item3 = Item.builder().id(3L).build();
            Item item4 = Item.builder().id(4L).build();
            Item item5 = Item.builder().id(5L).build();
            Item item6 = Item.builder().id(6L).build();

            Travel travel1 = Travel.builder()
                    .id(1L)
                    .days(List.of(d1,d2,d3))
                    .items(List.of(item1,item2))
                    .build();
            Travel travel2 = Travel.builder()
                    .id(2L)
                    .days(List.of(d4, d5))
                    .items(List.of(item3,item4, item5, item6))
                    .build();

            travelRepository.save(travel1);
            travelRepository.save(travel2);
            log.info("Loading Test Travels completed");
        };
    }


    @ConditionalOnProperty(
            prefix = "command-line-runner.data-loading.presets",
            value = "enabled",
            havingValue = "true",
            matchIfMissing = true)
    @Bean
    public CommandLineRunner presetDataLoader(TravelPresetRepository presetRepository) {
        return args -> {
            log.info("Loading Travel Presets ...");
            TravelPreset cyclingPreset = getCyclingPreset();
            presetRepository.save(cyclingPreset);


            log.info("Loading Travel Presets completed");
        };
    }

    @ConditionalOnProperty(
            prefix = "command-line-runner.data-loading.test-users",
            value = "enabled",
            havingValue = "true",
            matchIfMissing = true)
    @Bean
    public CommandLineRunner testUserLoader(UserService userService) {
        return args -> {
            log.info("Loading Test Users ...");
            UserDTO testUser = UserDTO.builder()
                    .username("test")
                    .password("test")
                    .email("test@test.com")
                    .build();
            userService.save(testUser);
            log.info("Loading Test Users completed");
        };
    }

}
