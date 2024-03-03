package com.mailsender.domain.model.user;

public interface IUserRepository {
    UserModel FindByUsername(String username);
    UserModel FindByEmailAddress(String emailAddress);
    UserModel FindById(Integer userId);
    void Save(UserModel user);
}
