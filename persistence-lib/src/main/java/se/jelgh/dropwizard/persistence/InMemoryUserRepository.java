package se.jelgh.dropwizard.persistence;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import org.modelmapper.ModelMapper;
import se.jelgh.dropwizard.core.User;
import se.jelgh.dropwizard.persistence.mysql.MySqlUser;

@Singleton
public class InMemoryUserRepository implements UserRepository {

    @Inject
    private ModelMapper mapper;

    private final Map<UUID, MySqlUser> usersById;

    public InMemoryUserRepository() {
        usersById = Maps.newHashMap();
    }

    public Optional<User> findById(UUID id) {
        MySqlUser mySqlUser = usersById.get(id);
        if (mySqlUser != null) {
            User user = mapper.map(mySqlUser, User.class);
            return Optional.ofNullable(user);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        Optional<MySqlUser> first = usersById.values().stream()
                .filter(mySqlUser -> username.equals(mySqlUser.getUsername()))
                .findFirst();

        if (first.isPresent()) {
            User user = mapper.map(first, User.class);
            return Optional.ofNullable(user);
        }
        return Optional.empty();
    }

    public User save(User user) {
        usersById.put(user.getId(), mapper.map(user, MySqlUser.class));
        return user;
    }
}
