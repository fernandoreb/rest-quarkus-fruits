package org.acme.rest.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.Set;

import org.acme.rest.json.*;

@Path("/fruits")
@RegisterRestClient(configKey = "fruits-api")
public interface PriceFruitService {

    @GET
    @Path("/{name}")
    FruitPrice getByName(@PathParam("name") String name);
}
