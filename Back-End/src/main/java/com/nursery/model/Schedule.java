package com.nursery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String description;
    private String activities;

    @ManyToMany(mappedBy = "schedules")
    private List<Child> children;

    // Constructors, getters and setters
    public Schedule() {
    }

    public Schedule(Date date, String description, String activities) {
        this.date = date;
        this.description = description;
        this.activities = activities;
    }
}
