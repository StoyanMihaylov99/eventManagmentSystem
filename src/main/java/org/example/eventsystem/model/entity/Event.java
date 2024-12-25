package org.example.eventsystem.model.entity;
import org.example.eventsystem.utils.Category;
import java.time.LocalDateTime;

public class Event {
    private String title;
    private LocalDateTime DateTime;
    private Category category;
    private int totalSeats;
    private int availableSeats;
    private User lead;
}
