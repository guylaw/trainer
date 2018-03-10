package com.kovumedia;

import com.kovumedia.health.ApplicationHealthCheck;
import com.kovumedia.resources.TrainerResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class TrainerApplication extends Application<TrainerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TrainerApplication().run(args);
    }

    @Override
    public String getName() {
        return "trainer";
    }

    @Override
    public void initialize(final Bootstrap<TrainerConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle());
    }

    @Override
    public void run(final TrainerConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.healthChecks().register(new String("trainer"), new ApplicationHealthCheck("myTemplate"));
        final TrainerResource resource = new TrainerResource(

                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);
    }

}
