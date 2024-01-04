package ru.prepare2travel.prepare2travelserver.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private UserSex sex;

    enum UserSex{
        male,
        female,
        other;
    }
}
