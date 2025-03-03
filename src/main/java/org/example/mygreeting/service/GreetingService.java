package org.example.mygreeting.service;

import org.example.mygreeting.model.Greeting;
import org.example.mygreeting.repository.GreetingRepository;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }

    // ✅ Fix: Save Greeting to Database
    public Greeting saveGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);  // This ensures data is saved in the database
    }
}