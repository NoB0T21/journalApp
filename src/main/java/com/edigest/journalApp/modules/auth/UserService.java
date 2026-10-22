package com.edigest.journalApp.modules.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserEntityRepo userEntityRepo;

    @Transactional
    public Optional<Boolean> createUser(UserEntity userEntity) {
        if (userEntity == null) return Optional.empty();
        if (
                userEntityRepo.existsByEmail(userEntity.getEmail()) ||
                userEntityRepo.existsByUserName(userEntity.getUserName())
        ) return Optional.of(false);
        try {
            userEntityRepo.save(userEntity);
            return Optional.of(true);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save user entity", e);
        }
    }
}
