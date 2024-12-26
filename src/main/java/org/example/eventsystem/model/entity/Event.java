package org.example.eventsystem.model.entity;

import jakarta.persistence.*;
import org.example.eventsystem.utils.Category;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "date_time")
    private String dateTime;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "total_seats")
    private int totalSeats;
    @Column(name = "available_seats")
    private int availableSeats;
    @ManyToOne
    private User admin;

    public Event() {
    }
}
