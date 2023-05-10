package com.mateus.cardoso.api.rest.dto;

import lombok.Builder;

@Builder
public record CreateUserDTO(
    String email,
    String password
) {
}
