package net.providerdetails.controller;

import net.providerdetails.exception.ResourceNotFoundException;
import net.providerdetails.model.Providers;
import net.providerdetails.repository.ProvideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/version1.0/")
public class ProviderController {
    @Autowired
    private ProvideRepository providerepository;

    @GetMapping("providers")
    public List<Providers> getAllProviders(){
        return providerepository.findAll();
    }

    @GetMapping("providers/{Id}")
    public ResponseEntity<Providers> getProviderById(@PathVariable(value = "Id") Long providerid)
            throws ResourceNotFoundException {
        Providers provider = providerepository.findById(providerid)
                .orElseThrow(() -> new ResourceNotFoundException("provider not found  :: " + providerid));
        return ResponseEntity.ok().body(provider);
    }
    @PostMapping("/providers/create-downtime")
    public Providers createProviders( @RequestBody Providers provider) {
        return providerepository.save(provider);
    }

    @PutMapping("/providers/update/{Id}")
    public ResponseEntity<Providers> updateProviders(@PathVariable(value = "Id") Long providerid,
                                                    @RequestBody Providers providerDetails) throws ResourceNotFoundException {
        Providers provider = providerepository.findById(providerid)
                .orElseThrow(() -> new ResourceNotFoundException("Provider not found  :: " + providerid));
        provider.setProvider_name(providerDetails.getProvider_name());
        provider.setFlow_name(providerDetails.getFlow_name());
        provider.setDownFrom(providerDetails.getDownFrom());
        provider.setDownTo(providerDetails.getDownTo());
        final Providers updatedProviders = providerepository.save(provider);
        return ResponseEntity.ok(updatedProviders);
    }

    @DeleteMapping("/providers/delete/{Id}")
    public Map<String, Boolean> deleteProvider(@PathVariable(value = "Id") Long providerid)
            throws ResourceNotFoundException {
        Providers provider = providerepository.findById(providerid)
                .orElseThrow(() -> new ResourceNotFoundException("Provider not found  :: " + providerid));

        providerepository.delete(provider);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
