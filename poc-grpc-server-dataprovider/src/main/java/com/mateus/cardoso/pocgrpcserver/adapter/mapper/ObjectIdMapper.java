package com.mateus.cardoso.pocgrpcserver.adapter.mapper;

import org.bson.types.ObjectId;
import org.mapstruct.Mapper;

import java.util.Optional;
import java.util.function.Predicate;

@Mapper(componentModel = "spring")
public interface ObjectIdMapper {

    default ObjectId toObjectId(final String id) {
        return Optional.ofNullable(id)
            .filter(Predicate.not(String::isBlank))
            .map(ObjectId::new)
            .orElse(null);
    }

    default String fromObjectId(final ObjectId id) {
        return Optional.ofNullable(id)
            .map(ObjectId::toHexString)
            .orElse(null);
    }
}
