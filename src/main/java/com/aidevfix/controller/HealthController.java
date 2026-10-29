package com.aidevfix.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @Value("${nebius.api.key:}") private String apiKey;
    @Value("${nebius.model}") private String model;

    @GetMapping("/api/v1/health")
    public Map<String, Object> health() {
        return Map.of("status", "UP", "application", "AI DevFix", "provider", "Nebius Token Factory",
                "model", model, "apiKeyConfigured", apiKey != null && !apiKey.isBlank());
    }
}
