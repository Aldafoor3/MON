package com.nursery.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterDTO {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String role;
    private String fidelity ;    //only for parents
    private String employeeRole; // only for employee
    private String experience;   //only for employees
    private int salary;          //only for employees



}






