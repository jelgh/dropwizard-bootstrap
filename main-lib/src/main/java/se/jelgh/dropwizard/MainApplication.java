package se.jelgh.dropwizard;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import se.jelgh.dropwizard.resources.v1.UserServiceResource;

public class MainApplication extends Application<MainConfiguration> {

    private Injector injector;

    public static void main(final String[] args) throws Exception {
        new MainApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-bootstrap";
    }

    @Override
    public void initialize(final Bootstrap<MainConfiguration> bootstrap) {
        injector = Guice.createInjector(new MainModule());
    }

    @Override
    public void run(final MainConfiguration configuration, final Environment env) {
        // TODO: implement application

        UserServiceResource userServiceResource = injector.getInstance(UserServiceResource.class);

        env.jersey().register(userServiceResource);

    }

}
