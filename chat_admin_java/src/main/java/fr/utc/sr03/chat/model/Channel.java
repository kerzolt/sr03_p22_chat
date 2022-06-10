package fr.utc.sr03.chat.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sr03_channels")
public class Channel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) // strategy=GenerationType.IDENTITY => obligatoire pour auto increment mysql
    private long id;

    private String title;

    private String description;

    private Date date;

    private long duration;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User owner;

    public Channel(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
