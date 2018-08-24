package com.mahmud.musicservice.app;

import org.glassfish.jersey.server.ResourceConfig;

public class MusicApplication extends ResourceConfig {
    public MusicApplication() {
        // Define the package which contains the service classes.
        packages("com.mahmud.musicservices");
    }
}