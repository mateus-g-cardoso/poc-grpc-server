package com.mateus.cardoso.pocgrpcserver.adapter.mapper;

import com.mateus.cardoso.api.rest.dto.CreateUserDTO;
import com.mateus.cardoso.api.rest.dto.UserResponseDTO;
import com.mateus.cardoso.core.domain.User;
import com.mateus.cardoso.grpc.lib.ListUserResponseGrpc;
import com.mateus.cardoso.grpc.lib.UserCreateGrpc;
import com.mateus.cardoso.grpc.lib.UserResponseGrpc;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = ObjectIdMapper.class)
public interface UserMapper {

    UserResponseDTO toDTO(User user);

    List<UserResponseDTO> toDTO(List<User> users);

    User toEntity(CreateUserDTO dto);

    User toEntity(UserResponseDTO dto);

    List<User> toEntity(List<UserResponseDTO> dtos);

    User toEntity(final UserCreateGrpc userGrpc);

    UserResponseGrpc toGrpc(final User user);

    default ListUserResponseGrpc toGrpc(final List<User> users) {
        final List<UserResponseGrpc> usersGrpc = Optional.ofNullable(users)
            .orElse(Collections.emptyList())
            .stream()
            .map(this::toGrpc)
            .toList();

        return ListUserResponseGrpc.newBuilder().addAllUsers(usersGrpc).build();
    }

}
