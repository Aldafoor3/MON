package com.nursery.service;

import com.nursery.model.Parent;
import com.nursery.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {
    private final ParentRepository parentRepository;

    @Autowired
    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public List<Parent> getAllParents() {
        return (List<Parent>) parentRepository.findAll();
    }

    public Optional<Parent> getParentById(Long id) {
        return parentRepository.findById(id);
    }

    public Parent saveParent(Parent parent) {
        return parentRepository.save(parent);
    }

    public void deleteParent(Long id) {
        parentRepository.deleteById(id);
    }

    public Parent updateParent(Long id, Parent parentDetails) {
        return parentRepository.findById(id)
                .map(parent -> {
                    parent.setFirstName(parentDetails.getFirstName());
                    parent.setLastName(parentDetails.getLastName());
                    parent.setUsername(parentDetails.getUsername());
                    parent.setEmail(parentDetails.getEmail());
                    parent.setPassword(parentDetails.getPassword());
                    parent.setAddress(parentDetails.getAddress());
                    parent.setPhone(parentDetails.getPhone());
                    parent.setFidelity (parentDetails.getFidelity ());
                    parent.setChildren(parentDetails.getChildren());
                    return parentRepository.save(parent);
                })
                .orElseThrow(() -> new RuntimeException("Parent not found with id " + id));
    }
}
