package se.jelgh.dropwizard.core;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class UserDTO {

    @Null
    private UUID id;
    @NotNull
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
