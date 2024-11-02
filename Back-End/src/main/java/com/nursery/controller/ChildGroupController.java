package com.nursery.controller;

import com.nursery.model.ChildGroup;
import com.nursery.service.ChildGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/childGroups")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:53928"})
public class ChildGroupController {

    private final ChildGroupService childGroupService;

    @Autowired
    public ChildGroupController(ChildGroupService childGroupService) {
        this.childGroupService = childGroupService;
    }

    @GetMapping
    public List<ChildGroup> getAllChildGroups() {
        return childGroupService.getAllChildGroups();
    }

    @GetMapping("/{id}")
    public Optional<ChildGroup> getChildGroupById(@PathVariable Long id) {
        return childGroupService.getChildGroupById(id);
    }

    @PostMapping("/saveChildGroup")
    public ChildGroup saveChildGroup(@RequestBody ChildGroup childGroup) {
        return childGroupService.saveChildGroup(childGroup);
    }

    @DeleteMapping("/{id}")
    public void deleteChildGroup(@PathVariable Long id) {
        childGroupService.deleteChildGroup(id);
    }

    @PutMapping("/{id}")
    public ChildGroup updateChildGroup(@PathVariable Long id, @RequestBody ChildGroup childGroupDetails) {
        return childGroupService.updateChildGroup(id, childGroupDetails);
    }
}
