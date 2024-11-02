package com.nursery.controller;

import com.nursery.model.Child;
import com.nursery.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/children")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:53928"})
public class ChildController {

    private final ChildService childService;

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping
    public List<Child> getAllChildren() {
        return childService.getAllChildren();
    }

    @GetMapping("/{id}")
    public Optional<Child> getChildById(@PathVariable Long id) {
        return childService.getChildById(id);
    }

    @PostMapping("/saveChild")
    public Child saveChild(@RequestBody Child child) {
        return childService.saveChild(child);
    }

    @DeleteMapping("/{id}")
    public void deleteChild(@PathVariable Long id) {
        childService.deleteChild(id);
    }

    @PutMapping("/{id}")
    public Child updateChild(@PathVariable Long id, @RequestBody Child childDetails) {
        return childService.updateChild(id, childDetails);
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<Child>> getChildrenByName(@RequestParam String name) {
        List<Child> children = childService.getChildrenByName(name);
        return ResponseEntity.ok(children);
    }
    @GetMapping("/parent/{parentId}")
    public ResponseEntity<List<Child>> getChildrenByParentId(@PathVariable Long parentId) {
        List<Child> children = childService.getChildrenByParentId(parentId);
        return ResponseEntity.ok(children);
    }
}
