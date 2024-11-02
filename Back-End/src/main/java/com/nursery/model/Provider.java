package com.nursery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String category;
    private String address;

    @OneToMany(mappedBy = "id")
    private List<Ressource> ressources;

    // Constructors, getters and setters
    public Provider() {
    }

    public Provider(String name, String email, String category, String address) {
        this.name = name;
        this.email = email;
        this.category = category;
        this.address = address;
    }
}
