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
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String behavior;
    private String img;
    private String name;
    private int age;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private ChildGroup group;

    @ManyToMany
    @JoinTable(
            name = "child_schedule",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id")
    )
    private List<Schedule> schedules;

    // Constructors, getters and setters
    public Child() {
    }

    public Child(String behavior, String img, String name, int age) {
        this.behavior = behavior;
        this.img = img;
        this.name = name;
        this.age = age;
    }
}
