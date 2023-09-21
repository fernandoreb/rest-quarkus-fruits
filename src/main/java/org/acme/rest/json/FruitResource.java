package org.acme.rest.json;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import org.acme.rest.client.*;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/fruits")
public class FruitResource {

    private Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    @RestClient
    PriceFruitService priceFruitService;

    @RestClient
    AMQFruitService amqFruitService;

    public FruitResource() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }

    @GET
    public Set<Fruit> list() {

        for (Fruit fruit : this.fruits) {
            fruit.price = priceFruitService.getByName(fruit.name).price;
        }

        return fruits;
    }

    @POST
    public Set<Fruit> add(Fruit fruit) {
        //fruits.add(fruit);

        amqFruitService.post("{\"name\":\"fruit.name\"}");

        return fruits;
    }

    @DELETE
    public Set<Fruit> delete(Fruit fruit) {
        fruits.removeIf(existingFruit -> existingFruit.name.contentEquals(fruit.name));
        return fruits;
    }
}
