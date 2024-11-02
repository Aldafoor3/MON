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
public class Parent extends User {
    private String fidelity ;

    @OneToMany(mappedBy = "id")
    private List<Child> children;

    // Constructors, getters and setters
    public Parent() {
    }

    public Parent(String firstName, String lastName, String username, String email, String password, String address, String phone, String fidelity ) {
        super(firstName, lastName, username, email, password, address, phone);
        this.fidelity  = fidelity ;
    }
}
