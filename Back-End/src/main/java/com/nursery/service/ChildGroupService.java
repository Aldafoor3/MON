package com.nursery.service;

import com.nursery.model.ChildGroup;
import com.nursery.repository.ChildGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildGroupService {
    private final ChildGroupRepository childGroupRepository;

    @Autowired
    public ChildGroupService(ChildGroupRepository childGroupRepository) {
        this.childGroupRepository = childGroupRepository;
    }

    public List<ChildGroup> getAllChildGroups() {
        return (List<ChildGroup>) childGroupRepository.findAll();
    }

    public Optional<ChildGroup> getChildGroupById(Long id) {
        return childGroupRepository.findById(id);
    }

    public ChildGroup saveChildGroup(ChildGroup childGroup) {
        return childGroupRepository.save(childGroup);
    }

    public void deleteChildGroup(Long id) {
        childGroupRepository.deleteById(id);
    }

    public ChildGroup updateChildGroup(Long id, ChildGroup childGroupDetails) {
        return childGroupRepository.findById(id)
                .map(childGroup -> {
                    childGroup.setName(childGroupDetails.getName());
                    childGroup.setChildren(childGroupDetails.getChildren());
                    return childGroupRepository.save(childGroup);
                })
                .orElseThrow(() -> new RuntimeException("ChildGroup not found with id " + id));
    }
}
