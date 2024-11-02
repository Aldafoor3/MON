package com.nursery.controller;

import com.nursery.model.Parent;
import com.nursery.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/parents")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:53928"})
public class ParentController {

    private final ParentService parentService;

    @Autowired
    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

    @GetMapping("/{id}")
    public Optional<Parent> getParentById(@PathVariable Long id) {
        return parentService.getParentById(id);
    }

    @PostMapping("/saveParent")
    public Parent saveParent(@RequestBody Parent parent) {
        return parentService.saveParent(parent);
    }

    @DeleteMapping("/{id}")
    public void deleteParent(@PathVariable Long id) {
        parentService.deleteParent(id);
    }

    @PutMapping("/{id}")
    public Parent updateParent(@PathVariable Long id, @RequestBody Parent parentDetails) {
        return parentService.updateParent(id, parentDetails);
    }
}
