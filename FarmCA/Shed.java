package FarmCA;

import java.util.ArrayList;
import java.util.UUID;

public class Shed {

    private ArrayList<Animal> herd;
    private MilkingMachine milkingMachine;
    private UUID id;

    public Shed(ArrayList<Animal> animal) {
        
        this.id = UUID.randomUUID();
        this.herd = animal;
    }

    public Shed(MilkingMachine milkingMachine) {
        this.id = UUID.randomUUID();
        this.milkingMachine = milkingMachine;
    }

    public Shed(MilkingMachine milkingMachine, ArrayList<Animal> animal) {
        this.id = UUID.randomUUID();
        this.milkingMachine = milkingMachine;
        this.herd = animal;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MilkingMachine getMilkingMachine() {
        return milkingMachine;
    }

    public void setMilkingMachine(MilkingMachine milkingMachine) {
        this.milkingMachine = milkingMachine;
    }


    public ArrayList<Animal> getHerd() {
        return herd;
    }

    public void setHerd(ArrayList<Animal> herd) {
        this.herd = herd;
    }

    public void addAnimal(Animal animal) {
        herd.add(animal);
    }

    public void removeAnimal(Animal animal) {
        herd.remove(animal);
    }

    public void removeAnimal(int index) {
        herd.remove(index);
    }

    public void removeAnimal(String name) {
        for (int i = 0; i < herd.size(); i++) {
            if (herd.get(i).getName().equals(name)) {
                herd.remove(i);
            }
        }
    }

    public void installMilkTank(MilkTank tank) {
        milkingMachine.setMilkTank(tank);
    }

    public void milkAnimals() {
        for (Animal animal : herd) {
            if (animal instanceof Milkable) {
                milkingMachine.milk((Milkable) animal);
            }
        }
    }

    public void printShedDetails() {
        System.out.println("Shed Details");
        System.out.println("============");
        for (Animal animal : herd) {
            System.out.println(animal);
        }
    }


    @Override
    public String toString() {
        return "Shed{" + "herd=" + herd + '}';
    }

}