package se.jelgh.dropwizard.resources;

import com.google.inject.Inject;
import java.util.Optional;
import java.util.UUID;
import se.jelgh.dropwizard.core.User;
import se.jelgh.dropwizard.persistence.UserRepository;

public class UserBusinessController {

    @Inject
    private UserRepository userRepository;

    public User get(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User register(User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID());
        }
        return userRepository.save(user);
    }
}

