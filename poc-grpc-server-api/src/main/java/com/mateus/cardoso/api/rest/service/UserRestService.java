package com.mateus.cardoso.api.rest.service;

import com.mateus.cardoso.api.rest.dto.CreateUserDTO;
import com.mateus.cardoso.api.rest.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        example = "645bd7cad27d792dc5de7a2b",
        in = ParameterIn.PATH,
        schema = @Schema(implementation = String.class)
    )
    UserResponseDTO getUser(@PathVariable String id);

    @GetMapping
    @Operation(summary = "List all users")
    List<UserResponseDTO> listAll();

    @PostMapping
    @Operation(summary = "Create a user")
    UserResponseDTO create(@RequestBody CreateUserDTO dto);
}
