package com.nursery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;

    // Constructors, getters and setters
    public Attendance() {
    }

    public Attendance(Date date, String status) {
        this.date = date;
        this.status = status;
    }
}
