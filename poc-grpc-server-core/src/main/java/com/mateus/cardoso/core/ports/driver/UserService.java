package com.mateus.cardoso.core.ports.driver;

import com.mateus.cardoso.core.domain.User;

import java.util.List;

public interface UserService {

    User find(String id);

    List<User> listAll();

    User create(User user);
}
