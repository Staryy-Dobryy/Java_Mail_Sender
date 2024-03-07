package com.mailsender.web.api;

import com.mailsender.domain.model.user.exceptions.RegistrationException;
import com.mailsender.domain.services.interfaces.IUserService;
import com.mailsender.domain.services.requests.CreateUserServiceRequest;
import com.mailsender.domain.services.requests.DeleteUserServiceRequest;
import com.mailsender.domain.services.requests.UpdateUserServiceRequest;
import com.mailsender.web.payload.CreateUserPayload;
import com.mailsender.web.payload.DeleteUserPayload;
import com.mailsender.web.payload.UpdateUserPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
public class UserApiController {

    private IUserService userService;

    public UserApiController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @RequestMapping(value = "/{login}")
    public ResponseEntity getUserByLogin(@PathVariable String login) {
        try {
            return ResponseEntity.ok(userService.findByLogin(login));
        }
        catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping
    @RequestMapping(value = "/list/{page}")
    public ResponseEntity getUsers(@PathVariable Integer page) {
        return ResponseEntity.ok(userService.getUsers(page));
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody CreateUserPayload payload){
        try {
            CreateUserServiceRequest request = payload.toRequest();
            userService.createUser(request);

            return ResponseEntity.ok().build();
        }
        catch (RegistrationException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UpdateUserPayload payload){
        UpdateUserServiceRequest request = payload.toRequest();
        userService.updateUser(request);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody DeleteUserPayload payload){
        DeleteUserServiceRequest request = payload.toRequest();
        userService.deleteUser(request);

        return ResponseEntity.ok().build();
    }
}
