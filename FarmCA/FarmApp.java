package FarmCA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FarmApp {

    public static void main(String[] args) throws FileNotFoundException {
        mainApp();
    }

    public static void mainMenu() {

        System.out.println("*** Farm App ***");
        System.out.println("1. Auto Fill Farm using default file");
        System.out.println("2. Auto Fill Farm using user specified file");
        System.out.println("3. Manually add a Farm");
        System.out.println("Q. Quit");
        System.out.print("Please enter your choice: ");
    }

    public static void farmMenu() {
        System.out.println("*** Farm Menu ***");
        System.out.println("1. Add a Shed");
        System.out.println("2. Add an Animal to a Shed");
        System.out.println("3. Print Farm Details");
        System.out.println("4. Print Shed Details");
        System.out.println("5. Print/Edit Animal Details");
        System.out.println("6. Print All Detaisl of a Farm");
        System.out.println("Q. Quit");
        System.out.print("Please enter your choice: ");
    }

    public static int printShedDetails(ArrayList<Shed> shedList) {

        System.out.println("*** Shed Details ***");
        for (int i = 0; i < shedList.size(); i++) {
            System.out.println((i + 1) + ". " + shedList.get(i).getId());
        }
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while (choice < 1 || choice > shedList.size()) {
            System.out.print("Please enter your choice: ");
            choice = sc.nextInt();
        }

        return choice - 1;
    }

    public static int printAllAnimals(ArrayList<Animal> animalList) {

        System.out.println("*** Animal Details ***");
        for (int i = 0; i < animalList.size(); i++) {
            System.out.println((i + 1) + ". " + animalList.get(i).getName());
        }
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while (choice < 1 || choice > animalList.size()) {
            System.out.print("Please enter your choice: ");
            choice = sc.nextInt();
        }

        return choice - 1;
    }

    public static void mainApp() throws FileNotFoundException {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        mainMenu();
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        Farm farm = choices(choice);

        if (farm != null) {

            while (true) {
                farmMenu();
                String farmChoice = sc.next();
                System.out.print("\033[H\033[2J");
                System.out.flush();
                int shedIndex;

                switch (farmChoice) {
                    case "1":
                        System.out.print("*** Add a Shed ***");
                        System.out.print("Please enter the shed name: ");
                        String shedName = sc.next();
                        farm.addShed(new Shed(shedName));
                        break;
                    case "2":
                        System.out.println("*** Add an Animal to a Shed ***");
                        System.out.println("--- Animal Types ---");
                        System.out.println("1. Dairy Cow");
                        System.out.println("2. Goat");
                        System.out.println("3. Sheep");
                        System.out.println("4. Beef Cow");
                        String animalType = sc.next();
                        shedIndex = printShedDetails(farm.getShedList());
                        switch (animalType) {
                            case "1":
                                System.out.print("Please enter the number of Dairy Cows: ");
                                int numberOfDairyCows = sc.nextInt();
                                for (int i = 0; i < numberOfDairyCows; i++) {
                                    farm.getShedList().get(shedIndex).addAnimal(new DairyCow());
                                }
                                break;
                            case "2":
                                System.out.print("Please enter the number of Goats: ");
                                int numberOfGoats = sc.nextInt();
                                for (int i = 0; i < numberOfGoats; i++) {
                                    farm.getShedList().get(shedIndex).addAnimal(new Goat());
                                }
                                break;
                            case "3":
                                System.out.print("Please enter the number of Sheep: ");
                                int numberOfSheep = sc.nextInt();
                                for (int i = 0; i < numberOfSheep; i++) {
                                    farm.getShedList().get(shedIndex).addAnimal(new Sheep());
                                }
                                break;
                            case "4":
                                System.out.print("Please enter the number of Beef Cows: ");
                                int numberOfBeefCows = sc.nextInt();
                                for (int i = 0; i < numberOfBeefCows; i++) {
                                    farm.getShedList().get(shedIndex).addAnimal(new BeefCow());
                                }
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                        break;
                    case "3":
                        System.out.println("*** Print Farm Details ***");
                        farm.printFarmDetails();
                        break;
                    case "4":
                        System.out.println("*** Print Shed Details ***");
                        shedIndex = printShedDetails(farm.getShedList());
                        farm.getShedList().get(shedIndex).printShedDetails();
                        break;
                    case "5":
                        System.out.println("*** Print/Edit Animal Details ***");
                        shedIndex = printShedDetails(farm.getShedList());
                        int index = printAllAnimals(farm.getShedList().get(shedIndex).getHerd());
                        System.out.println(farm.getShedList().get(shedIndex).getHerd().get(index).printAnimalDetails());
                        Animal a = farm.getShedList().get(shedIndex).getHerd().get(index);

                        System.out.println("1. Edit details");
                        System.out.println("2. Remove animal");
                        System.out.println("3. Return to main menu");
                        String animalChoice = sc.next();

                        switch (animalChoice) {

                            case "1":
                                System.out.println("Please enter a name");
                                String name = sc.next();
                                a.setName(name);
                                System.out.println("Please enter a id");
                                String id = sc.next();
                                a.setId(id);
                                farm.getShedList().get(shedIndex).getHerd().set(index, a);
                                break;
                            case "2":
                                farm.getShedList().get(shedIndex).getHerd().remove(index);
                                break;
                            case "3":
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;

                        }
                        break;
                    case "6":
                        System.out.println("*** Farm Details ***");
                        System.out.println(farm);
                        ArrayList<Shed> shedList = farm.getShedList();
                        System.out.println("\n---------------------");
                        System.out.println("____Shed Details____");
                        for (Shed shed : shedList) {
                            System.out.println(">>>> " + shed.getId() + " <<<<\n");
                            shed.printAllAnimalDetails();
                            System.out.println("____________________");
                        }
                        break;
                    case "Q":
                        System.out.println("Thank you for using Farm App");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }

        }
    }

    public static Farm choices(String choice) throws FileNotFoundException {
        Farm farm = null;
        switch (choice) {
            case "1":
                farm = fileReader("FarmCA/defaultFarmSetup.txt");
                break;
            case "2":
                System.out.print("Please enter the file path: ");
                Scanner sc = new Scanner(System.in);
                String path = sc.nextLine();
                farm = fileReader(path);
                break;
            case "3":
                farm = manualAddFarm();
                break;
            case "Q":
                System.out.println("Thank you for using Farm App");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        return farm;
    }

    public static Farm manualAddFarm() {
        System.out.println("*** Manually add a Farm ***");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the farm name: ");
        String farmName = sc.nextLine();
        System.out.print("Please enter the owner name: ");
        String ownerName = sc.nextLine();
        System.out.print("Please enter the number of sheds: ");
        int numberOfSheds = sc.nextInt();
        ArrayList<Shed> shedList = new ArrayList<>();
        Farm farm = new Farm(farmName, ownerName, shedList);
        if (numberOfSheds > 0) {
            for (int i = 0; i < numberOfSheds; i++) {
                System.out.print("Please enter the shed name: ");
                String shedName = sc.next();
                shedList.add(new Shed(shedName));
                System.out.print("Please enter the number of animals: ");
                int numberOfAnimals = sc.nextInt();
                for (int j = 0; j < numberOfAnimals; j++) {

                    System.out.println("*** Animal Types ***");
                    System.out.println("1. Dairy Cow");
                    System.out.println("2. Goat");
                    System.out.println("3. Sheep");
                    System.out.println("4. Beef Cow");
                    String animalType = sc.next();

                    switch (animalType) {
                        case "1":
                            System.out.print("Please enter the number of Dairy Cows: ");
                            int numberOfDairyCows = sc.nextInt();
                            for (int k = 0; k < numberOfDairyCows; k++) {
                                System.out.print("Please enter the name of the Dairy Cow: ");
                                String name = sc.next();
                                DairyCow dairyCow = new DairyCow(name);
                                shedList.get(i).addAnimal(dairyCow);
                            }
                            break;
                        case "2":
                            System.out.print("Please enter the number of Goats: ");
                            int numberOfGoats = sc.nextInt();
                            for (int k = 0; k < numberOfGoats; k++) {
                                System.out.print("Please enter the name of the Goat: ");
                                String name = sc.next();
                                Goat goat = new Goat(name);
                                shedList.get(i).addAnimal(goat);
                            }
                            break;
                        case "3":
                            System.out.print("Please enter the number of Sheep: ");
                            int numberOfSheep = sc.nextInt();
                            for (int k = 0; k < numberOfSheep; k++) {
                                System.out.print("Please enter the name of the Sheep: ");
                                String name = sc.next();
                                Sheep sheep = new Sheep(name);
                                shedList.get(i).addAnimal(sheep);
                            }
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;

                    }
                }
            }
        }

        return farm;
    }

    public static Farm fileReader(String path) throws FileNotFoundException {
        System.out.println("*** Auto Fill Farm using default file ***");

        try {
            File file = new File(path);
            try (Scanner sc = new Scanner(file)) {
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

            }

        } catch (Exception e) {
            System.out.println("File not found");

        }

        return null;

    }
}
