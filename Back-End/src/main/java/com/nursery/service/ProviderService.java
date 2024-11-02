package com.nursery.service;

import com.nursery.model.Provider;
import com.nursery.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> getAllProviders() {
        return (List<Provider>) providerRepository.findAll();
    }

    public Optional<Provider> getProviderById(Long id) {
        return providerRepository.findById(id);
    }

    public Provider saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public void deleteProvider(Long id) {
        providerRepository.deleteById(id);
    }

    public Provider updateProvider(Long id, Provider providerDetails) {
        return providerRepository.findById(id)
                .map(provider -> {
                    provider.setName(providerDetails.getName());
                    provider.setEmail(providerDetails.getEmail());
                    provider.setCategory(providerDetails.getCategory());
                    provider.setAddress(providerDetails.getAddress());
                    provider.setRessources(providerDetails.getRessources());
                    return providerRepository.save(provider);
                })
                .orElseThrow(() -> new RuntimeException("Provider not found with id " + id));
    }
}
