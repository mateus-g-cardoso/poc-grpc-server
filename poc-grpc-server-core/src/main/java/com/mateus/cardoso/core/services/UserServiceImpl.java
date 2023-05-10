package com.mateus.cardoso.core.services;

import com.mateus.cardoso.core.domain.User;
import com.mateus.cardoso.core.ports.driven.UserRepository;
import com.mateus.cardoso.core.ports.driver.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public User find(final String id) {
        log.info("Find user by id: %s".formatted(id));

        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        if (id.isBlank()) {
            throw new IllegalArgumentException("Id cannot be blank");
        }

        return Optional.ofNullable(repository.findById(id))
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> listAll() {
        return repository.findAll();
    }

    @Override
    public User create(final User user) {
        if (Objects.nonNull(user.getId())) {
            throw new IllegalArgumentException("Id needs to be null");
        }

        if (repository.isEmailInUse(user.getEmail())) {
            throw new RuntimeException("Email is already registered");
        }


        return repository.create(user);
    }

}
