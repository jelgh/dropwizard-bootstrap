package se.jelgh.dropwizard;

import com.google.inject.AbstractModule;
import se.jelgh.dropwizard.persistence.InMemoryUserRepository;
import se.jelgh.dropwizard.persistence.UserRepository;

public class MainModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserRepository.class).to(InMemoryUserRepository.class);
    }
}
