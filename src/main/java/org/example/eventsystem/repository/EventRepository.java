package org.example.eventsystem.repository;

import org.example.eventsystem.model.entity.Event;
import org.example.eventsystem.utils.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {

    Optional<List<Event>> findEventsByCategory(Category category);

    Optional<Event> findByTitle(String title);

    void deleteById(String id);

}
