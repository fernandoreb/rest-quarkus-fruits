package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestForm;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.FormParam;
import java.util.Set;

import org.acme.rest.json.*;

@Path("/api")
@RegisterRestClient(configKey = "amq-producer-api")
public interface AMQFruitService {

    @POST
    @Path("/producer")
    @Produces(MediaType.APPLICATION_JSON)
    String post(@RestForm String message);
}
