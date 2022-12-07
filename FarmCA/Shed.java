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

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public void removeAnimal(int index) {
        animals.remove(index);
    }

    public void removeAnimal(String name) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getName().equals(name)) {
                animals.remove(i);
            }
        }
    }

    public void printShedDetails() {
        System.out.println("Shed Details");
        System.out.println("============");
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }


    @Override
    public String toString() {
        return "Shed{" + "animals=" + animals + '}';
    }

}