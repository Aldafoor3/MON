package com.nursery.security;

import com.nursery.model.Employee;
import com.nursery.model.Manager;
import com.nursery.model.Parent;
import com.nursery.repository.EmployeeRepository;
import com.nursery.repository.ManagerRepository;
import com.nursery.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // First, search in the Manager table
        UserDetails userDetails = loadUserByUsernameFromManager(username);
        // If not found, check in the Parent table
        if (userDetails == null) {
            userDetails = loadUserByUsernameFromParent(username);
        }
        // If not found, check in the Employee table
        if (userDetails == null) {
            userDetails = loadUserByUsernameFromEmployee(username);
        }
        // If not found in any table, throw an exception
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return userDetails;
    }

    public UserDetails loadUserByUsernameFromManager(String username) throws UsernameNotFoundException {
        Manager manager = managerRepository.findByUsername(username);
        if (manager == null) {
            return null;
        }
        return new CustomUserDetails(manager);
    }

    public UserDetails loadUserByUsernameFromParent(String username) throws UsernameNotFoundException {
        Parent parent = parentRepository.findByUsername(username);
        if (parent == null) {
            return null;
        }
        return new CustomUserDetails(parent);
    }

    public UserDetails loadUserByUsernameFromEmployee(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);
        if (employee == null) {
            return null;
        }
        return new CustomUserDetails(employee);
    }
}

