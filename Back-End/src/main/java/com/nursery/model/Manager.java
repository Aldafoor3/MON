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
public class Manager extends User {
    @OneToMany(mappedBy = "id")
    private List<Employee> employees;

    @OneToMany(mappedBy = "id")
    private List<Ressource> ressources;

    // Constructors, getters and setters
    public Manager() {
    }

    public Manager(String firstName, String lastName, String username, String email, String password, String address, String phone) {
        super(firstName, lastName, username, email, password, address, phone);
    }
}
