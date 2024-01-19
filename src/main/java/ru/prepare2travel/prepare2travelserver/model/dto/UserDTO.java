package ru.prepare2travel.prepare2travelserver.model.dto;


import jakarta.persistence.ElementCollection;
import lombok.*;
import ru.prepare2travel.prepare2travelserver.model.User;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.List;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class UserDTO {
    private Long id;
    private String sex;
    private String username;
    private String email;
    private String password;
    private Long registeredAt;

    private List<String> roles;
}
