package org.acme.rest.json;

public class Fruit {

    public String name;
    public String description;
    public String price;

    public Fruit() {
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
        this.price = "R$ 0,00";
    }
}