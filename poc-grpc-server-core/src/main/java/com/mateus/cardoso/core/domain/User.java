package com.mateus.cardoso.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;

    private String email;

    private String password;
}
