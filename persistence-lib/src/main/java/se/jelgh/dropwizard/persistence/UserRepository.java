package se.jelgh.dropwizard.persistence;

import java.util.Optional;
import java.util.UUID;
import se.jelgh.dropwizard.core.User;

public interface UserRepository {

    Optional<User> findById(UUID id);

    Optional<User> findByUsername(String username);

    User save(User user);

}
