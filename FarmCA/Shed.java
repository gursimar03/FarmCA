package FarmCA;

import java.util.ArrayList;

public class Shed {

    private ArrayList<Animal> animals;

    public Shed(ArrayList<Animal> animal) {
        this.animals = animal;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

}