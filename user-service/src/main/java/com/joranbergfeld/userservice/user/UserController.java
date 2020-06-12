package com.joranbergfeld.userservice.user;

import com.joranbergfeld.userservice.domain.User;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<UserResponse> getAll() {
        List<User> users = userService.getAllUsers();
        return users.stream().map(UserResponse::fromUser).collect(Collectors.toList());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getListById(@PathVariable("id") long id) {
        Optional<User> optionalUser = Optional.ofNullable(userService.getUserById(id));
        return optionalUser.map(user -> new ResponseEntity<>(UserResponse.fromUser(user), HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/user")
    public ResponseEntity<UserResponse> createUser(@RequestBody final CreateUserRequest request) {
        User user = userService.createUser(CreateUserRequest.toUser(request));
        return new ResponseEntity<>(UserResponse.fromUser(user), HttpStatus.CREATED);
    }
}
