package org.example.eventsystem.model.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;
    @Column(name = "user_name", nullable = false)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "created", nullable = false)
    private String created;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Event> events;

    public User() {
    }
}
