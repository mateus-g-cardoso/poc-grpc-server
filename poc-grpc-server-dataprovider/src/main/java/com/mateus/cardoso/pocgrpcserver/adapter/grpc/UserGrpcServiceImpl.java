package com.mateus.cardoso.pocgrpcserver.adapter.grpc;

import com.google.protobuf.Empty;
import com.mateus.cardoso.core.domain.User;
import com.mateus.cardoso.core.ports.driver.UserService;
import com.mateus.cardoso.grpc.lib.Id;
import com.mateus.cardoso.grpc.lib.ListUserResponseGrpc;
import com.mateus.cardoso.grpc.lib.UserCreateGrpc;
import com.mateus.cardoso.grpc.lib.UserResponseGrpc;
import com.mateus.cardoso.grpc.lib.UserServiceGrpc;
import com.mateus.cardoso.pocgrpcserver.adapter.mapper.UserMapper;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
@RequiredArgsConstructor
public class UserGrpcServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    private final UserMapper userMapper;
    private final UserService userService;

    @Override
    public void findById(final Id request, final StreamObserver<UserResponseGrpc> response) {
        final User user = userService.find(request.getId());

        final UserResponseGrpc userResponse = userMapper.toGrpc(user);

        response.onNext(userResponse);
        response.onCompleted();
    }

    @Override
    public void listAll(final Empty request, final StreamObserver<ListUserResponseGrpc> response) {
        final var users = userService.listAll();

        final var usersRepose = userMapper.toGrpc(users);

        response.onNext(usersRepose);
        response.onCompleted();
    }

    @Override
    public void create(final UserCreateGrpc request, final StreamObserver<UserResponseGrpc> response) {
        final var user = userService.create(userMapper.toEntity(request));

        final var userResponse = userMapper.toGrpc(user);

        response.onNext(userResponse);
        response.onCompleted();
    }
}
