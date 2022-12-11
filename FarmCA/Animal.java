package FarmCA;

import java.util.UUID;

//Using the UUID class to generate a unique ID for each animal
//The UUID class is in the java.util package

public abstract class Animal {

    private String id;
    protected String name;

    public Animal() {
        this.id = UUID.randomUUID().toString();
    }

    public Animal(String name) {

        // converting the UUID to a string
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

    // abstract method to print the details of the animal
    abstract public String printAnimalDetails();

    @Override
    public String toString() {
        return "Name: " + name + "\n ID: " + id;
    }

    // comparing the animal objects
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }

}