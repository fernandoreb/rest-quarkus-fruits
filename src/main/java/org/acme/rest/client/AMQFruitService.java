package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.Set;

import org.acme.rest.json.*;

@Path("/api")
@RegisterRestClient(configKey = "amq-producer-api")
public interface AMQFruitService {

    @POST
    @Path("/producer")
    String post(String message);
}
