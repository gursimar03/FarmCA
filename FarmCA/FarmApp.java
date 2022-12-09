package FarmCA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FarmApp {

    public static void main(String[] args) throws FileNotFoundException {

        choice1();
        Farm farm = choice1();

        farm.getShedList().get(0).setMilkingMachine(new MilkingMachine());
        farm.getShedList().get(0).installTankForCow(new MilkTank());
        farm.getShedList().get(0).installTankForGoat(new MilkTank());

        farm.getShedList().get(0).milkAnimals();
        farm.getShedList().get(1).milkAnimals();
        MilkingMachine m = farm.getShedList().get(0).getMilkingMachine();
        System.out.println(m);
    }

    public static void menu() {

        System.out.println("*** Farm App ***");
        System.out.println("1. Auto Fill Farm using default file");
        System.out.println("2. Auto Fill Farm using user specified file");
        System.out.println("3. Manually add a Farm");
        System.out.println("Q. Quit");
        System.out.print("Please enter your choice: ");
    }

    public static Farm choice1() throws FileNotFoundException {
        System.out.println("*** Auto Fill Farm using default file ***");

        try {
            File file = new File("FarmCA/defaultFarmSetup.txt");
            Scanner sc = new Scanner(file);
            boolean flag = true;
            while (sc.hasNextLine() && flag) {

                String cursor = sc.next();
                int numberOfSheds = sc.nextInt();
                ArrayList<Shed> shedList = new ArrayList<>();
                Farm farm = new Farm(cursor, shedList);

                for (int j = 0; j < numberOfSheds; j++) {
                    shedList.add(new Shed(sc.next()));
                    int numberofAnimals = sc.nextInt();
                    for (int i = 0; i < numberofAnimals; i++) {

                        String animalType = sc.next();
                        if (animalType.equals("DairyCow")) {

                            int numbers = sc.nextInt();

                            for (int k = 0; k < numbers; k++) {
                                String name = sc.next();
                                if (name.equals("xxx")) {
                                    DairyCow a = new DairyCow();
                                    shedList.get(j).addAnimal(a);
                                } else {
                                    DairyCow a = new DairyCow(name);
                                    shedList.get(j).addAnimal(a);
                                }
                            }

                        } else if (animalType.equals("Goat")) {

                            int numbers = sc.nextInt();

                            for (int k = 0; k < numbers; k++) {
                                String name = sc.next();
                                if (name.equals("xxx")) {
                                    Goat a = new Goat();
                                    shedList.get(j).addAnimal(a);
                                } else {
                                    Goat a = new Goat(name);
                                    shedList.get(j).addAnimal(a);
                                }
                            }

                        } else if (animalType.equals("Sheep")) {

                            int numbers = sc.nextInt();

                            for (int k = 0; k < numbers; k++) {
                                String name = sc.next();
                                if (name.equals("xxx")) {
                                    Sheep a = new Sheep();
                                    shedList.get(j).addAnimal(a);
                                } else {
                                    Sheep a = new Sheep(name);
                                    shedList.get(j).addAnimal(a);
                                }
                            }
                        } else if (animalType.equals("BeefCow")) {
                            int numbers = sc.nextInt();

                            for (int k = 0; k < numbers; k++) {
                                String name = sc.next();
                                if (name.equals("xxx")) {
                                    BeefCow a = new BeefCow();
                                    shedList.get(j).addAnimal(a);
                                } else {
                                    BeefCow a = new BeefCow(name);
                                    shedList.get(j).addAnimal(a);
                                }
                            }
                        } else {
                            System.out.println("Invalid Animal Type");
                            int numbers = sc.nextInt();

                            for (int k = 0; k < numbers; k++) {
                                sc.next();
                            }
                        }
                    }
                }

                return farm;
            }
            
            sc.close();

        } catch (Exception e) {
            System.out.println("File not found");

        }

        return null;

    }
}
