package com.kovumedia.resources;

import com.codahale.metrics.annotation.Timed;
import com.kovumedia.api.Trainer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/trainer")
@Produces(MediaType.APPLICATION_JSON)
public class TrainerResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public TrainerResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Trainer getDefaultTrainer(){
        return new Trainer(9, "Trainer Name");
    }

    @GET
    @Path("{id}")
    @Timed
    public Trainer getTrainer(@PathParam("id") long id){
        return new Trainer(id, "Trainer Name");
    }

}
