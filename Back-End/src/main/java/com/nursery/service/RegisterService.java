package com.nursery.service;

import com.nursery.model.RegisterDTO;
import com.nursery.model.Parent;
import com.nursery.model.Employee;
import com.nursery.model.Manager;
import com.nursery.repository.ParentRepository;
import com.nursery.repository.EmployeeRepository;
import com.nursery.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(RegisterDTO registerDTO) {
        switch (registerDTO.getRole().toLowerCase()) {
            case "parent":
                registerParent(registerDTO);
                break;
            case "employee":
                registerEmployee(registerDTO);
                break;
            case "manager":
                registerManager(registerDTO);
                break;
            default:
                throw new IllegalArgumentException("Invalid role!");
        }
    }

    private void registerParent(RegisterDTO registerDTO) {
        Parent parent = new Parent(registerDTO.getFirstName(), registerDTO.getLastName(),
                registerDTO.getUsername(), registerDTO.getEmail(),
                passwordEncoder.encode(registerDTO.getPassword()), registerDTO.getAddress(),
                registerDTO.getPhone(), registerDTO.getFidelity());

        parentRepository.save(parent);
    }

    private void registerEmployee(RegisterDTO registerDTO) {
        Employee employee = new Employee(registerDTO.getFirstName(), registerDTO.getLastName(),
                registerDTO.getUsername(), registerDTO.getEmail(),
                passwordEncoder.encode(registerDTO.getPassword()), registerDTO.getAddress(),
                registerDTO.getPhone(), registerDTO.getEmployeeRole(), registerDTO.getExperience(), registerDTO.getSalary());

        employeeRepository.save(employee);
    }

    private void registerManager(RegisterDTO registerDTO) {
        Manager manager = new Manager(registerDTO.getFirstName(), registerDTO.getLastName(),
                registerDTO.getUsername(), registerDTO.getEmail(),
                passwordEncoder.encode(registerDTO.getPassword()), registerDTO.getAddress(),
                registerDTO.getPhone());

        managerRepository.save(manager);
    }
}
