package com.study.customerService.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.study.customerService.rs.UserResource;

@Component
@ApplicationPath("/ws")
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig(){
        //packages("com.example.study");
        register(UserResource.class);
    }
}