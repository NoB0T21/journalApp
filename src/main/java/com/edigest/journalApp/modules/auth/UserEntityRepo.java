package com.edigest.journalApp.modules.auth;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserEntityRepo extends MongoRepository<UserEntity, ObjectId> {
    boolean existsByEmail(String email);

    boolean existsByUserName(String userName);

    UserEntity findByEmail(String email);

    UserEntity findByUserName(String userName);
}
