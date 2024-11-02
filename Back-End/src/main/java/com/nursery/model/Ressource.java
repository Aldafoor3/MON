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
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String state;
    private String type;
    private int price;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    // Constructors, getters and setters
    public Ressource() {
    }

    public Ressource(String state, String type, int price, Date date) {
        this.state = state;
        this.type = type;
        this.price = price;
        this.date = date;
    }
}
