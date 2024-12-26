package org.example.eventsystem.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "uuid-string")
    private String id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "created")
    private String created;
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private Set<Event> events;

    public User() {
    }
}
