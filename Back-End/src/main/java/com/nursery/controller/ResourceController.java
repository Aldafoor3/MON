package com.nursery.controller;

import com.nursery.model.Ressource;
import com.nursery.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:53928"})
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public List<Ressource> getAllResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/{id}")
    public Optional<Ressource> getResourceById(@PathVariable Long id) {
        return resourceService.getResourceById(id);
    }

    @PostMapping("/saveResource")
    public Ressource saveResource(@RequestBody Ressource ressource) {
        return resourceService.saveResource(ressource);
    }

    @DeleteMapping("/{id}")
    public void deleteResource(@PathVariable Long id) {
        resourceService.deleteResource(id);
    }

    @PutMapping("/{id}")
    public Ressource updateResource(@PathVariable Long id, @RequestBody Ressource ressourceDetails) {
        return resourceService.updateResource(id, ressourceDetails);
    }
}
