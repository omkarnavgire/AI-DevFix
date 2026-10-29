package com.aidevfix.dto;

public record AnalysisResponse(
        boolean success,
        String project,
        String provider,
        String model,
        String language,
        String analysis,
        String message
) {}
