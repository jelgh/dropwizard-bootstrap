package se.jelgh.dropwizard.api.v1;

import java.util.UUID;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import se.jelgh.dropwizard.core.UserDTO;

@Path(MainService.API_V1 + "/user")
public interface UserService extends MainService {

    @GET
    @Path("{id}")
    UserDTO get(@PathParam(value = "id") UUID id);

    @POST
    UserDTO register(@Valid UserDTO user);

}
