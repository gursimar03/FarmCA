package FarmCA;

import java.util.UUID;


public abstract class Animal {

    private int id;
    private String name;

    public Animal(String name) {
        
        this.id = UUID.randomUUID().toString();

        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

   @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", name=" + name + '}';
    }



}