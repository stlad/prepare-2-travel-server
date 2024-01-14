package ru.prepare2travel.prepare2travelserver.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "travel_presets")
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class TravelPreset {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Item> itemsPerTravel;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Item> itemsPerDay;

}
