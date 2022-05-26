package com.example;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {

    @ConfigProperty(name = "greetings.message", defaultValue = "jack")
    String prop;

    @Inject @Superior
    Movie instance1;

    @Inject
    double PPPI;

    @Inject
    Movie instance2;

    @Inject
    List<String> pps;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Fruit> getOneFruit() {
        return Uni.createFrom().item(Fruit::new);
    }

    @GET
    @Path("prop")
    @Produces(MediaType.TEXT_PLAIN)
    public String getProperty() {
        return prop;
    }

    @GET
    @Path("mv")
    public Boolean getMv() {
        System.out.println(instance1.getClass());
        System.out.println(instance2.getClass());
        System.out.println(PPPI);
        System.out.println(pps);
        return instance1==instance2;
    }


}
