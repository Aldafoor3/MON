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
public class Employee extends User {
    private String employeeRole;
    private String experience;
    private int salary;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToMany(mappedBy = "id")
    private List<Leaves> leaves;

    // Constructors, getters and setters
    public Employee() {
    }

    public Employee(String firstName, String lastName, String username, String email, String password, String address, String phone, String employeeRole, String experience, int salary) {
        super(firstName, lastName, username, email, password, address, phone);
        this.employeeRole = employeeRole;
        this.experience = experience;
        this.salary = salary;
    }
}
