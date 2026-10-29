package com.aidevfix.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CodeAnalysisRequest(
        @NotBlank(message = "Paste the source code you want to analyse")
        @Size(max = 30000, message = "Code must be 30000 characters or fewer")
        String code,
        @NotBlank(message = "Programming language is required")
        @Size(max = 50, message = "Language must be 50 characters or fewer")
        String language,
        @Size(max = 3000, message = "Error message must be 3000 characters or fewer")
        String errorMessage
) {}
