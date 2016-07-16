package se.jelgh.dropwizard.resources.v1;

import com.google.inject.Inject;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import se.jelgh.dropwizard.api.v1.UserService;
import se.jelgh.dropwizard.core.User;
import se.jelgh.dropwizard.core.UserDTO;
import se.jelgh.dropwizard.resources.UserBusinessController;

public class UserServiceResource implements UserService {

    @Inject
    private UserBusinessController controller;

    @Inject
    private ModelMapper mapper;

    public UserServiceResource() {
    }

    @Override
    public UserDTO get(UUID id) {
        User user = controller.get(id);
        return mapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO register(UserDTO userDTO) {
        User user = mapper.map(userDTO, User.class);

        User registeredUser = controller.register(user);

        return mapper.map(registeredUser, UserDTO.class);
    }
}
