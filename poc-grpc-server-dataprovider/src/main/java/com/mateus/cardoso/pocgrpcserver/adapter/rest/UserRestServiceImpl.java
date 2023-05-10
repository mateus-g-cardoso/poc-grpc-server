package com.mateus.cardoso.pocgrpcserver.adapter.rest;

import com.mateus.cardoso.api.rest.dto.UserDTO;
import com.mateus.cardoso.api.rest.service.UserRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserRestServiceImpl implements UserRestService {

    @Override
    public UserDTO getUser(final Long id) {
        return UserDTO.builder().email("usr@usr.usr").password("1234").id(id).build();
    }

}
