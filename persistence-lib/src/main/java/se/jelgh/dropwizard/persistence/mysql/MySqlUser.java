package se.jelgh.dropwizard.persistence.mysql;

import java.util.Date;
import java.util.UUID;

public class MySqlUser {
    private Date created;
    private UUID id;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
