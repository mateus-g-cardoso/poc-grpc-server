package com.mateus.cardoso.api.rest.dto;

import lombok.*;

@Builder
public record UserResponseDTO(
    String id,
    String email,
    String password
) {
}
