package ru.prepare2travel.prepare2travelserver.model.dto;


import lombok.*;

@Data
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class UserDTO {
    private Long id;
    private String sex;
}
