package com.nursery.controller;

import com.nursery.model.Provider;
import com.nursery.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/providers")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:53928"})
public class ProviderController {

    private final ProviderService providerService;

    @Autowired
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GetMapping("/{id}")
    public Optional<Provider> getProviderById(@PathVariable Long id) {
        return providerService.getProviderById(id);
    }

    @PostMapping("/saveProvider")
    public Provider saveProvider(@RequestBody Provider provider) {
        return providerService.saveProvider(provider);
    }

    @DeleteMapping("/{id}")
    public void deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
    }

    @PutMapping("/{id}")
    public Provider updateProvider(@PathVariable Long id, @RequestBody Provider providerDetails) {
        return providerService.updateProvider(id, providerDetails);
    }
}
