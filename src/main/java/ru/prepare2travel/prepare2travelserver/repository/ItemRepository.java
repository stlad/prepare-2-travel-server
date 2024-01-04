package ru.prepare2travel.prepare2travelserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.prepare2travel.prepare2travelserver.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
