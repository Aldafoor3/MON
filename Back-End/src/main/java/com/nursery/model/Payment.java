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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String mode;
    private int amount;
    private String status;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    // Constructors, getters and setters
    public Payment() {
    }

    public Payment(Date date, String mode, int amount, String status) {
        this.date = date;
        this.mode = mode;
        this.amount = amount;
        this.status = status;
    }
}
