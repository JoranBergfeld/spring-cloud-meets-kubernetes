package com.joranbergfeld.userservice.user;

import com.joranbergfeld.userservice.domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(final long id) {
        Optional<UserEntity> byId = this.userRepository.findById(id);
        return byId.map(UserEntity::toUser).orElse(null);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll().stream().map(UserEntity::toUser).collect(Collectors.toList());
    }

    public User createUser(User userToCreate) {
        UserEntity createdUser = userRepository.save(UserEntity.fromUser(userToCreate));
        return UserEntity.toUser(createdUser);
    }
}
