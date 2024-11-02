package com.nursery.service;

import com.nursery.model.Ressource;
import com.nursery.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceService {
    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<Ressource> getAllResources() {
        return (List<Ressource>) resourceRepository.findAll();
    }

    public Optional<Ressource> getResourceById(Long id) {
        return resourceRepository.findById(id);
    }

    public Ressource saveResource(Ressource ressource) {
        return resourceRepository.save(ressource);
    }

    public void deleteResource(Long id) {
        resourceRepository.deleteById(id);
    }

    public Ressource updateResource(Long id, Ressource ressourceDetails) {
        return resourceRepository.findById(id)
                .map(resource -> {
                    resource.setState(ressourceDetails.getState());
                    resource.setType(ressourceDetails.getType());
                    resource.setPrice(ressourceDetails.getPrice());
                    resource.setDate(ressourceDetails.getDate());
                    resource.setManager(ressourceDetails.getManager());
                    resource.setProvider(ressourceDetails.getProvider());
                    return resourceRepository.save(resource);
                })
                .orElseThrow(() -> new RuntimeException("Resource not found with id " + id));
    }
}
