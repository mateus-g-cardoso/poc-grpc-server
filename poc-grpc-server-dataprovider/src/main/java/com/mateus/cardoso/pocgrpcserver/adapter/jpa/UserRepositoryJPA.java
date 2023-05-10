package com.mateus.cardoso.pocgrpcserver.adapter.jpa;

import com.mateus.cardoso.core.domain.User;
import com.mateus.cardoso.core.ports.driven.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface UserRepositoryJPA extends UserRepository, MongoRepository<User, ObjectId> {
    Map<String, User> usersDB = new HashMap<>();

    @Override
    default User findById(final String id) {
//        return User.builder().id(new ObjectId(id)).email("tst@user.com").password("admin_admin").build();
        return usersDB.get(id);
    }

    default List<User> findAll() {
        return usersDB.values().stream().toList();
    }

    default User create(final User user) {
        final var id = new ObjectId();

        user.setId(id);
        usersDB.put(id.toHexString(), user);

        return user;
    }

    default boolean isEmailInUse(final String email) {
        return usersDB.values()
            .stream()
            .map(User::getEmail)
            .anyMatch(e -> e.equals(email));
    }
}
