package com.nursery.service;

import com.nursery.model.Employee;
import com.nursery.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstName(employeeDetails.getFirstName());
                    employee.setLastName(employeeDetails.getLastName());
                    employee.setUsername(employeeDetails.getUsername());
                    employee.setEmail(employeeDetails.getEmail());
                    employee.setPassword(employeeDetails.getPassword());
                    employee.setAddress(employeeDetails.getAddress());
                    employee.setPhone(employeeDetails.getPhone());
                    employee.setEmployeeRole(employeeDetails.getEmployeeRole());
                    employee.setExperience(employeeDetails.getExperience());
                    employee.setSalary(employeeDetails.getSalary());
                    employee.setManager(employeeDetails.getManager());
                    employee.setLeaves(employeeDetails.getLeaves());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }
}
