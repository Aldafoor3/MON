package com.nursery.service;

import com.nursery.model.Child;
import com.nursery.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildService {
    private final ChildRepository childRepository;

    @Autowired
    public ChildService(ChildRepository childRepository) {
        this.childRepository = childRepository;
    }

    // Fetch all children
    public List<Child> getAllChildren() {
        return (List<Child>) childRepository.findAll();
    }

    // Fetch a child by ID
    public Optional<Child> getChildById(Long id) {
        return childRepository.findById(id);
    }

    // Save a new child
    public Child saveChild(Child child) {
        return childRepository.save(child);
    }

    // Delete a child by ID
    public void deleteChild(Long id) {
        childRepository.deleteById(id);
    }

    // Find children by name
    public List<Child> getChildrenByName(String name) {
        return childRepository.findByName(name);
    }

    // Find children by parent ID
    public List<Child> getChildrenByParentId(Long parentId) {
        return childRepository.findByParentId(parentId);
    }

    // Update an existing child
    public Child updateChild(Long id, Child childDetails) {
        return childRepository.findById(id)
                .map(child -> {
                    child.setBehavior(childDetails.getBehavior());
                    child.setImg(childDetails.getImg());
                    child.setName(childDetails.getName());
                    child.setAge(childDetails.getAge());
                    child.setParent(childDetails.getParent());
                    child.setGroup(childDetails.getGroup());
                    child.setSchedules(childDetails.getSchedules());
                    return childRepository.save(child);
                })
                .orElseThrow(() -> new RuntimeException("Child not found with id " + id));
    }
}
