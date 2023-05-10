package com.mateus.cardoso.api.rest.service;

import com.mateus.cardoso.api.rest.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(
    name = "User",
    description = "User's endpoints"
)
@RequestMapping(path = UserRestService.PATH)
public interface UserRestService {

    String PATH = "/users";

    @GetMapping("/{id}")
    @Operation(summary = "Find user by id")
    @Parameter(
        name = "id",
        description = "ID of the user you are trying to find",
        example = "42",
        in = ParameterIn.PATH,
        schema = @Schema(implementation = Long.class)
    )
    UserDTO getUser(@PathVariable Long id);
}
