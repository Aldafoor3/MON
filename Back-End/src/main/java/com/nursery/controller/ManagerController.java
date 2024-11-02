package com.nursery.controller;

import com.nursery.model.Manager;
import com.nursery.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/managers")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:53928"})
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/{id}")
    public Optional<Manager> getManagerById(@PathVariable Long id) {
        return managerService.getManagerById(id);
    }

    @PostMapping("/saveManager")
    public Manager saveManager(@RequestBody Manager manager) {
        return managerService.saveManager(manager);
    }

    @DeleteMapping("/{id}")
    public void deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
    }

    @PutMapping("/{id}")
    public Manager updateManager(@PathVariable Long id, @RequestBody Manager managerDetails) {
        return managerService.updateManager(id, managerDetails);
    }
}
