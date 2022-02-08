package com.ym.projects.apis.posapi.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {
    private LocalDateTime timestamp;
    private String errorCode;
    private String message;
    @Singular(ignoreNullCollections = true)
    private Map<String, String> details;


}
