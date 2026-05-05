package com.verichain.le.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/scanner")
@CrossOrigin(origins = "*")
public class ScannerController {

    @PostMapping("/scan")
    public Map<String, Object> scanProfile(@RequestBody Map<String, String> request) {
        String profile = request.getOrDefault("profile", "");
        String platform = request.getOrDefault("platform", "twitter");

        // Simulated scan results
        Map<String, Object> result = new HashMap<>();
        result.put("username", profile.replace("@", ""));
        result.put("displayName", profile.replace("@", "").replace("_", " ").replace(".", " ").toUpperCase());
        result.put("created", "March 2021");
        result.put("followers", "45.2K");
        
        // Generate mock risk score
        int riskScore = (int) (Math.random() * 100);
        result.put("riskScore", riskScore);
        
        // Risk factors - 6 Fake ID Detection Criteria
        List<Map<String, Object>> factors = new ArrayList<>();
        factors.add(Map.of("name", "Sudden Follower Increase", "score", Math.min(100, riskScore + 15), "level", riskLevel(riskScore + 15)));
        factors.add(Map.of("name", "Profile Name/Picture Changes", "score", Math.max(0, riskScore - 10), "level", riskLevel(riskScore - 10)));
        factors.add(Map.of("name", "Sudden Post Increase", "score", Math.min(100, riskScore + 20), "level", riskLevel(riskScore + 20)));
        factors.add(Map.of("name", "AI-Generated Images", "score", Math.min(100, riskScore + 25), "level", riskLevel(riskScore + 25)));
        factors.add(Map.of("name", "Mass Message Forwarding", "score", Math.max(0, riskScore - 5), "level", riskLevel(riskScore - 5)));
        factors.add(Map.of("name", "Follower Ratio Anomaly", "score", Math.max(0, riskScore - 15), "level", riskLevel(riskScore - 15)));
        result.put("factors", factors);
        
        return result;
    }

    private String riskLevel(int score) {
        if (score >= 75) return "high";
        if (score >= 50) return "medium";
        return "low";
    }
}