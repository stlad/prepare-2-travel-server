package ru.prepare2travel.prepare2travelserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.prepare2travel.prepare2travelserver.model.Day;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {
}
