package org.example.eventsystem.model.dto;
import org.example.eventsystem.utils.Category;
import java.time.LocalDateTime;
import java.util.UUID;

public class EventDTO {
    private String id;
    private String title;
    private String eventTime;
    private Category category;
    private int totalSeats;
    private int availableSeats;
    private UserDTO admin;

    public EventDTO(String title, LocalDateTime eventTime, Category category, int totalSeats, UserDTO admin) throws IllegalAccessException {
        setId();
        setTitle(title);
        setEventTime(eventTime);
        setCategory(category);
        setTotalSeats(totalSeats);
        setAvailableSeats(totalSeats);
        setAdmin(admin);
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalAccessException{
        if (title.trim().isEmpty()) {
            throw new IllegalAccessException("The title can't be empty or null.");
        }
        this.title = title;
    }

    public String getDateTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) throws IllegalAccessException {
        if (eventTime == null) {
            throw new IllegalAccessException("The date can't be null");
        }
        if (eventTime.isBefore(LocalDateTime.now())) {
            throw new IllegalAccessException("The date can't be before today.");
        }
        this.eventTime = eventTime.toString();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) throws IllegalAccessException {
        if (category == null) {
            throw new IllegalAccessException("The category can't be null");
        }
        this.category = category;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) throws IllegalAccessException {
        if (totalSeats <= 0) {
            throw new IllegalAccessException("Seats should be a positive number.");
        }
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) throws IllegalAccessException {
        if(availableSeats <= 0){
            throw new IllegalAccessException("The seats should be a positive number.");
        }
        this.availableSeats = availableSeats;
    }

    public UserDTO getAdmin() {
        return admin;
    }

    public void setAdmin(UserDTO admin) throws IllegalAccessException {
        if(admin == null){
            throw new IllegalAccessException("Admin can't be null.");
        }
        this.admin = admin;
    }
}
