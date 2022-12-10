package FarmCA;

import java.util.ArrayList;
import java.util.UUID;

public class Shed {

    private ArrayList<Animal> herd;
    private MilkingMachine milkingMachine;
    private String id;

    public Shed(ArrayList<Animal> animal) {
        
        this.id = UUID.randomUUID().toString();
        this.herd = animal;
    }

    public Shed() {
        this.id = UUID.randomUUID().toString();
        this.herd = new ArrayList<>();
    }

    public Shed(String id){
        this.id = id;
        this.herd = new ArrayList<>();
    }

    

    public Shed(MilkingMachine milkingMachine, ArrayList<Animal> animal, String id) {
        this.milkingMachine = milkingMachine;
        this.herd = animal;
        this.id = id;
    }

    public Shed(MilkingMachine milkingMachine) {
        this.id = UUID.randomUUID().toString();
        this.milkingMachine = milkingMachine;
    }

    public Shed(MilkingMachine milkingMachine, ArrayList<Animal> animal) {
        this.id = UUID.randomUUID().toString();
        this.milkingMachine = milkingMachine;
        this.herd = animal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void installTankForCow(MilkTank tank){
        milkingMachine.setCowMilk(tank);
    }

    public void installTankForGoat(MilkTank tank){
        milkingMachine.setGoatMilk(tank);
    }

    public void printAllAnimalDetails() {
        for (Animal animal : herd) {
            System.out.println(animal.printAnimalDetails());
        }
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