package com.verichain.le.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
public class DashboardController {

    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("profilesScanned", 12847);
        stats.put("activeCases", 47);
        stats.put("fakeDetected", 3291);
        stats.put("evidenceLocked", 8934);
        return stats;
    }

    @GetMapping("/activity")
    public List<Map<String, String>> getActivity() {
        List<Map<String, String>> activities = new ArrayList<>();
        activities.add(Map.of("type", "scan", "text", "Profile @crypto_king_999 scanned successfully", "time", "2 minutes ago"));
        activities.add(Map.of("type", "alert", "text", "High risk profile detected: @fake_news_agency (Risk: 91%)", "time", "15 minutes ago"));
        activities.add(Map.of("type", "lock", "text", "Evidence EV-8A3F2C locked to blockchain", "time", "32 minutes ago"));
        activities.add(Map.of("type", "verify", "text", "Profile sarah.tech.linkedin verified as authentic", "time", "1 hour ago"));
        activities.add(Map.of("type", "scan", "text", "Profile john.smith_official scanned successfully", "time", "2 hours ago"));
        return activities;
    }

    @GetMapping("/status")
    public Map<String, Object> getSystemStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("blockchain", "SYNCED");
        status.put("api", "CONNECTED");
        status.put("activeNodes", "12/12");
        status.put("timestamp", new Date().toString());
        return status;
    }
}