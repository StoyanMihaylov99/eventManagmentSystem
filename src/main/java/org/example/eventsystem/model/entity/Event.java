package org.example.eventsystem.model.entity;

import jakarta.persistence.*;
import org.example.eventsystem.utils.Category;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "event_time", nullable = false)
    private String eventTime;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "total_seats", nullable = false)
    private int totalSeats;
    @Column(name = "available_seats", nullable = false)
    private int availableSeats;
    @ManyToOne
    private User admin;

    public Event() {
    }

    public String getId() {
        return id;
    }
}
