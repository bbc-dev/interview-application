package com.spring.interview.dto;

import java.time.LocalDateTime;

public record ReviewResponseDTO(String id, String comment, String author, LocalDateTime postDate) {
}
