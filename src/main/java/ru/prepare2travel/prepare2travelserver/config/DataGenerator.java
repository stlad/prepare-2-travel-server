package ru.prepare2travel.prepare2travelserver.config;

import ru.prepare2travel.prepare2travelserver.model.Item;
import ru.prepare2travel.prepare2travelserver.model.TravelPreset;

import java.util.List;

public class DataGenerator {
    public static TravelPreset getCyclingPreset(){
        return TravelPreset.builder()
                .name("Cycling tourism")
                .itemsPerTravel(List.of(
                        Item.builder().have(0).name("Bike").needed(1).build(),
                        Item.builder().have(0).name("Tent").needed(1).build(),
                        Item.builder().have(0).name("Sleeping Bag").needed(1).build(),
                        Item.builder().have(0).name("Cooking Gear").needed(1).build(),
                        Item.builder().have(0).name("Headlight").needed(1).build(),
                        Item.builder().have(0).name("Spare Tires").needed(2).build(),
                        Item.builder().have(0).name("Bike Lock").needed(1).build(),
                        Item.builder().have(0).name("Camera").needed(1).build(),
                        Item.builder().have(0).name("Charger").needed(1).build(),
                        Item.builder().have(0).name("Phone").needed(1).build(),
                        Item.builder().have(0).name("Id and Money").needed(1).build(),
                        Item.builder().have(0).name("Toiletries").needed(1).build(),
                        Item.builder().have(0).name("Clothes").needed(5).build(),
                        Item.builder().have(0).name("Rain gear").needed(1).build()
                ))
                .itemsPerDay(List.of(
                        Item.builder().have(0).name("Water").needed(2).build(),
                        Item.builder().have(0).name("Energy Bars").needed(3).build(),
                        Item.builder().have(0).name("Meals").needed(3).build(),
                        Item.builder().have(0).name("Sunscreen").needed(1).build(),
                        Item.builder().have(0).name("Maps").needed(1).build(),
                        Item.builder().have(0).name("First Aid Kit").needed(1).build(),
                        Item.builder().have(0).name("Repair Kit").needed(1).build(),
                        Item.builder().have(0).name("Spare Tube").needed(1).build(),
                        Item.builder().have(0).name("Pump").needed(1).build(),
                        Item.builder().have(0).name("Helmet").needed(1).build(),
                        Item.builder().have(0).name("Gloves").needed(1).build(),
                        Item.builder().have(0).name("Cycling Shorts").needed(1).build(),
                        Item.builder().have(0).name("Cycling Jersey").needed(1).build(),
                        Item.builder().have(0).name("Cycling Shoes").needed(1).build()
                )).build();
    }
}
