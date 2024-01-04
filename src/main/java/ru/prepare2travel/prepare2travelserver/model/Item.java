package ru.prepare2travel.prepare2travelserver.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "items")
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer needed;

    private Integer have;
}
