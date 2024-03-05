package com.mailsender.domain.services.interfaces;

import com.mailsender.domain.model.user.PublicUserModel;
import com.mailsender.domain.model.user.UserModel;
import com.mailsender.domain.model.user.exceptions.RegistrationException;
import com.mailsender.domain.model.user.exceptions.UserNotFoundException;
import com.mailsender.domain.services.requests.CreateUserServiceRequest;
import com.mailsender.domain.services.requests.DeleteUserServiceRequest;
import com.mailsender.domain.services.requests.UpdateUserServiceRequest;

import java.util.List;

public interface IUserService {
    List<UserModel> getUsers(Integer page);
    PublicUserModel findByLogin(String login) throws UserNotFoundException;
    void createUser(CreateUserServiceRequest request) throws RegistrationException;
    void updateUser(UpdateUserServiceRequest request);
    void deleteUser(DeleteUserServiceRequest request);
}
