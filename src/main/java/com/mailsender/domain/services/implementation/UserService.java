package com.mailsender.domain.services.implementation;

import com.mailsender.domain.model.user.PublicUserModel;
import com.mailsender.domain.model.user.RegistrationHandler;
import com.mailsender.domain.model.user.UserModel;
import com.mailsender.domain.model.user.exceptions.RegistrationException;
import com.mailsender.domain.model.user.exceptions.UserNotFoundException;
import com.mailsender.domain.services.interfaces.IUserService;
import com.mailsender.domain.services.requests.CreateUserServiceRequest;
import com.mailsender.domain.services.requests.DeleteUserServiceRequest;
import com.mailsender.domain.services.requests.UpdateUserServiceRequest;
import com.mailsender.infrastructure.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final Integer PAGE_SIZE = 5;

    private UserRepository userRepository;
    private RegistrationHandler registrationHandler;

    public UserService(UserRepository userRepository, RegistrationHandler registrationHandler) {
        this.userRepository = userRepository;
        this.registrationHandler = registrationHandler;
    }

    @Override
    public List<UserModel> getUsers(Integer page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE, Sort.by("createdOn"));
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    public PublicUserModel findByLogin(String login) throws UserNotFoundException {

        UserModel user;
        if (login.contains("@")) {
            user = userRepository.findByEmail(login);
        }
        else {
            user = userRepository.findByUsername(login);
        }

        if (user == null) {
            throw new UserNotFoundException(login);
        }

        return new PublicUserModel(user);
    }

    @Override
    public void createUser(CreateUserServiceRequest request) throws RegistrationException {
        registrationHandler.register(

                request.getUsername(),
                request.getEmail()
        );
    }

    @Override
    public void updateUser(UpdateUserServiceRequest request) {
        UserModel user = getUserById(request.getId());

        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());

        userRepository.save(user);
    }

    @Override
    public void deleteUser(DeleteUserServiceRequest request) {
        UserModel user = getUserById(request.getId());

        userRepository.delete(user);
    }

    private UserModel getUserById(Integer id){
        UserModel user = userRepository.findById(id).get();
        Assert.notNull(user, "User with id" + id + "not exist");
        return user;
    }
}


