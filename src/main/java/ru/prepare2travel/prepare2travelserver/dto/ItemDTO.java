package ru.prepare2travel.prepare2travelserver.dto;


import lombok.*;

@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class ItemDTO {
    private Long id;
    private String name;
    private Integer needed;
    private Integer have;
}
