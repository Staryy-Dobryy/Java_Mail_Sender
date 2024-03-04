package com.mailsender.infrastructure.repository;

import com.mailsender.domain.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByEmail(String email);
    UserModel findByUsername(String username);
}