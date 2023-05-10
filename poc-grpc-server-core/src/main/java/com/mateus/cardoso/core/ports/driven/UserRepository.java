package com.mateus.cardoso.core.ports.driven;

import com.mateus.cardoso.core.domain.User;

import java.util.List;

public interface UserRepository {

    User findById(String id);

    List<User> findAll();

    User create(User user);

    boolean isEmailInUse(String email);
}
