package FarmCA;

import java.util.UUID;


public abstract class Animal {

    private String id;
    protected String name;

    public Animal() {
        this.id = UUID.randomUUID().toString();
    }

    public Animal(String name) {
        
        this.id = UUID.randomUUID().toString();

        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public String printAnimalDetails();

   @Override
    public String toString() {
        return "Name: " + name + "\n ID: " + id;
    }



}