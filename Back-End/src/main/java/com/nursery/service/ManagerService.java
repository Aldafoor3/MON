package com.nursery.service;

import com.nursery.model.Manager;
import com.nursery.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getAllManagers() {
        return (List<Manager>) managerRepository.findAll();
    }

    public Optional<Manager> getManagerById(Long id) {
        return managerRepository.findById(id);
    }

    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
    }

    public Manager updateManager(Long id, Manager managerDetails) {
        return managerRepository.findById(id)
                .map(manager -> {
                    manager.setFirstName(managerDetails.getFirstName());
                    manager.setLastName(managerDetails.getLastName());
                    manager.setUsername(managerDetails.getUsername());
                    manager.setEmail(managerDetails.getEmail());
                    manager.setPassword(managerDetails.getPassword());
                    manager.setAddress(managerDetails.getAddress());
                    manager.setPhone(managerDetails.getPhone());
                    manager.setEmployees(managerDetails.getEmployees());
                    manager.setRessources(managerDetails.getRessources());
                    return managerRepository.save(manager);
                })
                .orElseThrow(() -> new RuntimeException("Manager not found with id " + id));
    }
}
