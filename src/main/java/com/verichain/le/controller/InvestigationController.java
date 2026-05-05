package com.verichain.le.controller;

import com.verichain.le.model.Investigation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api/investigations")
@CrossOrigin(origins = "*")
public class InvestigationController {

    private final List<Investigation> investigations = new ArrayList<>(Arrays.asList(
        new Investigation("CASE-2024-0847", "@crypto_king_999", "twitter", 87, "threat", LocalDate.of(2024, 1, 15)),
        new Investigation("CASE-2024-0846", "john.smith_official", "facebook", 62, "warning", LocalDate.of(2024, 1, 14)),
        new Investigation("CASE-2024-0845", "@invest_alerts", "twitter", 94, "threat", LocalDate.of(2024, 1, 14)),
        new Investigation("CASE-2024-0844", "sarah.tech.linkedin", "linkedin", 12, "verified", LocalDate.of(2024, 1, 13)),
        new Investigation("CASE-2024-0843", "@free_followers_now", "instagram", 78, "warning", LocalDate.of(2024, 1, 12))
    ));

    @GetMapping
    public List<Investigation> getAllInvestigations() {
        return investigations;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investigation> getInvestigation(@PathVariable String id) {
        return investigations.stream()
            .filter(inv -> inv.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Investigation createInvestigation(@RequestBody Investigation investigation) {
        investigation.setId("CASE-2024-" + String.format("%04d", investigations.size() + 848));
        investigation.setDate(LocalDate.now());
        investigations.add(0, investigation);
        return investigation;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestigation(@PathVariable String id) {
        boolean removed = investigations.removeIf(inv -> inv.getId().equals(id));
        return removed ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}