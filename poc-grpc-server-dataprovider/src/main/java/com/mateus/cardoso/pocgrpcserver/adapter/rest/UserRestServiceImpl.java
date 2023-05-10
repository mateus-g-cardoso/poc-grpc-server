package com.mateus.cardoso.pocgrpcserver.adapter.rest;

import com.mateus.cardoso.api.rest.dto.CreateUserDTO;
import com.mateus.cardoso.api.rest.dto.UserResponseDTO;
import com.mateus.cardoso.api.rest.service.UserRestService;
import com.mateus.cardoso.core.ports.driver.UserService;
import com.mateus.cardoso.pocgrpcserver.adapter.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserRestServiceImpl implements UserRestService {

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO getUser(final String id) {
        final var user = userService.find(id);
        return userMapper.toDTO(user);
    }

    @Override
    public List<UserResponseDTO> listAll() {
        final var user = userService.listAll();

        return userMapper.toDTO(user);
    }

    @Override
    public UserResponseDTO create(final CreateUserDTO dto) {
        final var user = userService.create(userMapper.toEntity(dto));

        return userMapper.toDTO(user);
    }

}
