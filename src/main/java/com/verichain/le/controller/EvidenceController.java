package com.verichain.le.controller;

import com.verichain.le.model.Evidence;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/evidence")
@CrossOrigin(origins = "*")
public class EvidenceController {

    private final List<Evidence> evidenceList = new ArrayList<>(Arrays.asList(
        new Evidence("EV-8A3F2C", "@crypto_king_999", "twitter", "a7f3b2c1...", "J. Doe", LocalDateTime.of(2024, 1, 15, 14, 32)),
        new Evidence("EV-7B2E1D", "john.smith_official", "facebook", "9d4ae3f2...", "M. Smith", LocalDateTime.of(2024, 1, 14, 10, 15)),
        new Evidence("EV-6C1D0C", "@invest_alerts", "twitter", "2f8ba1c9...", "J. Doe", LocalDateTime.of(2024, 1, 14, 9, 45)),
        new Evidence("EV-5D0E9B", "sarah.tech.linkedin", "linkedin", "4c2df8a7...", "A. Lee", LocalDateTime.of(2024, 1, 13, 16, 20)),
        new Evidence("EV-4E1F8A", "@free_followers_now", "instagram", "8f3ad7b6...", "M. Smith", LocalDateTime.of(2024, 1, 12, 11, 8))
    ));

    @GetMapping
    public List<Evidence> getAllEvidence() {
        return evidenceList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evidence> getEvidence(@PathVariable String id) {
        return evidenceList.stream()
            .filter(ev -> ev.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Evidence lockEvidence(@RequestBody Evidence evidence) {
        evidence.setId("EV-" + String.format("%X", System.currentTimeMillis()).substring(0, 6).toUpperCase());
        evidence.setTimestamp(LocalDateTime.now());
        evidenceList.add(0, evidence);
        return evidence;
    }
}