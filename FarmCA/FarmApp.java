package FarmCA;

import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FarmApp {

    public static void main(String[] args) throws FileNotFoundException {
        mainApp();
    }

    // mainMenu to print the main menu
    public static void mainMenu() {

        System.out.println();
        System.out.println("*** Farm App ***");
        System.out.println("1. Auto Fill Farm using default file");
        System.out.println("2. Auto Fill Farm using user specified file");
        System.out.println("3. Manually add a Farm");
        System.out.println("Q. Quit");
        System.out.print("Please enter your choice: ");
    }

    // farmMenu to print the farm menu so that we can use it multiple times
    public static void farmMenu() {
        System.out.println();
        System.out.println("*** Farm Menu ***");
        System.out.println("1. Add a Shed");
        System.out.println("2. Add an Animal to a Shed");
        System.out.println("3. Print/Edit Farm Details");
        System.out.println("4. Print/Edit Shed Details");
        System.out.println("5. Print/Edit Animal Details");
        System.out.println("6. Print All Details of a Farm");
        System.out.println("7. Auto install neccessary milking machine and tanks");
        System.out.println("8. Milk all Animals");
        System.out.println("9. Show tank status");
        System.out.println("10. Report a Dead Animal");
        System.out.println("11. Regular Milk Collection ");
        System.out.println("12. Export Farm Details to a file");
        System.out.println("13. View Sorted Animals");
        System.out.println("Q. Quit");
        System.out.print("Please enter your choice: ");
    }

    // Method to get the choice from the user and return index of the
    public static int printShedDetails(ArrayList<Shed> shedList) {

        System.out.println("*** Shed Details ***");
        for (int i = 0; i < shedList.size(); i++) {
            System.out.println((i + 1) + ". " + shedList.get(i).getId());
        }

        Scanner sc = new Scanner(System.in);

        int choice = 0;
        System.out.print("Please enter your choice: ");
        while (choice < 1 || choice > shedList.size()) {
            choice = sc.nextInt();
        }

        // return the index of the shed
        return choice - 1;
    }

    // Method to get the choice from the user and return index of the
    public static int printAllAnimals(ArrayList<Animal> animalList) {

        System.out.println("*** Animal Details ***");
        for (int i = 0; i < animalList.size(); i++) {
            System.out.println((i + 1) + ". " + animalList.get(i).getName());
        }
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        System.out.print("Please enter your choice: ");
        while (choice < 1 || choice > animalList.size()) {
            choice = sc.nextInt();
        }

        return choice - 1;
    }

    public static void mainApp() throws FileNotFoundException {

        // Clear the screen
        System.out.print("\033[H\033[2J");
        System.out.flush();

        String choice = "";
        Scanner sc = new Scanner(System.in);

        while (true) {

            mainMenu();
            choice = sc.nextLine();

            if (choice.equals("1") || choice.equals("2") || choice.equals("3")) {
                break;
            } else if (choice.equals("Q") || choice.equals("q")) {
                System.exit(0);
            }
        }

        // Creates a farm object which is returned from choices method
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
                        // Add a shed
                        System.out.println("*** Add a Shed ***");
                        System.out.print("Please enter the shed name: ");
                        String shedName = sc.next();
                        farm.addShed(new Shed(shedName));
                        break;

                    case "2":
                        // Add an animal to a shed
                        System.out.println("*** Add an Animal to a Shed ***");
                        System.out.println("--- Animal Types ---");
                        System.out.println("1. Dairy Cow");
                        System.out.println("2. Goat");
                        System.out.println("3. Sheep");
                        System.out.println("4. Beef Cow");

                        System.out.print("Please enter the animal type: ");
                        String animalType = sc.next();

                        // Get the index of the shed
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
                        System.out.println("*** Print/Edit Farm Details ***");
                        farm.printFarmDetails();
                        System.out.println("1. Edit details");
                        System.out.println("2. Remove shed");
                        System.out.println("3. Return to main menu");
                        String farmDetailsChoice = sc.next();
                        switch (farmDetailsChoice) {
                            case "1":
                                System.out.print("Please enter the new owner's name: ");
                                String farmName = sc.next();
                                farm.setOwnerName(farmName);
                                System.out.println("Please enter new ID: ");
                                String farmID = sc.next();
                                farm.setFarmID(farmID);

                                System.out.println("--- Farm details updated ---");

                                break;
                            case "2":
                                shedIndex = printShedDetails(farm.getShedList());
                                farm.removeShed(farm.getShedList().get(shedIndex));
                                break;
                            case "3":
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                        break;

                    case "4":

                        System.out.println("*** Print/Edit Shed Details ***");
                        shedIndex = printShedDetails(farm.getShedList());
                        farm.getShedList().get(shedIndex).printShedDetails();
                        System.out.println("1. Edit details");
                        System.out.println("2. Remove shed");
                        System.out.println("3. Return to main menu");
                        String shedDetailsChoice = sc.next();
                        switch (shedDetailsChoice) {
                            case "1":
                                System.out.print("Please enter the new shed ID: ");
                                String n = sc.next();
                                farm.getShedList().get(shedIndex).setId(n);
                                System.out.println("--- Shed details updated ---");
                                break;
                            case "2":
                                farm.removeShed(farm.getShedList().get(shedIndex));
                                break;
                            case "3":
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
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

                    case "7":
                        System.out.println("*** Auto Installing Machine and Tanks ***\n");
                        ArrayList<Shed> shedList1 = farm.getShedList();

                        for (Shed shed : shedList1) {

                            if (shed.getMilkingMachine() == null && shed.isMilkable()) {
                                shed.setMilkingMachine(new MilkingMachine());
                                System.out.println(">>> Milking Machine installed in " + shed.getId());

                                ArrayList<Animal> herd = shed.getHerd();

                                for (Animal animal : herd) {
                                    if (animal instanceof DairyCow) {
                                        if (shed.getMilkingMachine().getCowMilkTank() == null) {
                                            shed.installTankForCow(new MilkTank());
                                            System.out.println("    Milk Tank installed in " + shed.getId() + " for "
                                                    + animal.getClass().getSimpleName());
                                        }
                                    } else if (animal instanceof Goat) {
                                        if (shed.getMilkingMachine().getGoatMilkTank() == null) {
                                            shed.installTankForGoat(new MilkTank());
                                            System.out.println("    Milk Tank installed in " + shed.getId() + " for "
                                                    + animal.getClass().getSimpleName());
                                        }
                                    }
                                }
                            } else {
                                System.out.println(">>> No Milking Machine Needed " + shed.getId());
                            }
                        }
                        break;

                    case "8":
                        System.out.println("*** Milking ***\n");
                        ArrayList<Shed> shedList2 = farm.getShedList();

                        for (Shed shed : shedList2) {
                            if (shed.getMilkingMachine() != null) {
                                System.out.println("    >>> Milking " + shed.getId());
                                shed.milkAnimals();
                            } else {
                                System.out.println("    >>> No Milking Machine in " + shed.getId());
                            }
                        }
                        System.out.println("Milking Complete");

                        break;

                    case "9":

                        System.out.println("*** Tank Status ***\n");
                        ArrayList<Shed> shedList3 = farm.getShedList();

                        for (Shed shed : shedList3) {
                            shed.printMilkingMachineDetails();
                        }

                        break;

                    case "10":

                        System.out.println("*** Report A Dead Animal ***");
                        shedIndex = printShedDetails(farm.getShedList());
                        index = printAllAnimals(farm.getShedList().get(shedIndex).getHerd());
                        farm.getShedList().get(shedIndex).getHerd().remove(index);
                        System.out.println("Animal removed");

                        break;

                    case "11":

                        System.out.println("*** Regular Milk Collection ***");
                        ArrayList<Shed> shedList4 = farm.getShedList();
                        for (Shed shed : shedList4) {
                            if (shed.getMilkingMachine() != null) {
                                shed.getMilkingMachine().emptyMilkTanks();
                                System.out.println("    >>> Tank(s) Emptied in " + shed.getId());
                                shed.milkAnimals();
                            } else {
                                System.out.println("    >>> No Milking Machine in " + shed.getId());
                            }
                        }

                        break;

                    case "12":
                        System.out.println("*** Export Data to file ***");
                        System.out.println("1. Export to default file");
                        System.out.println("2. Export to custom file");
                        String exportChoice = sc.next();
                        switch (exportChoice) {
                            case "1":
                                saveDataInFile(farm, "FarmCA/savedDetails.txt");
                                break;
                            case "2":
                                System.out.print("Please enter the file path: ");
                                Scanner sc1 = new Scanner(System.in);
                                String path = sc1.nextLine();
                                saveDataInFile(farm, path);
                                break;
                            default:
                                System.out.println("Invalid choice");
                                break;
                        }
                        break;

                    case "13":
                        System.out.println("*** Sort Animals ***");
                        System.out.println("1. Sort Dairy Cows Mike Production");
                        System.out.println("2. Sort Goats by Milk Production");
                        System.out.print("Please enter your choice:");
                        String systemChoice = sc.next();
                        
                        if(systemChoice.equals("1")){
                            System.out.println("Dairy Cows sorted by Milk Production");
                            ArrayList<DairyCow> cows = farm.sortDairyCow();

                           System.out.println("------------------------------------");
                            System.out.format("%-15s %s \n", "Name", "Udder Size");
                            System.out.println("____________________________________");
                            for (DairyCow cow : cows) {
                                System.out.format("%-15s %s", cow.getName(), cow.getUdderSize());
                                System.out.println();
                            }
                        }else if(systemChoice.equals("2")){
                            System.out.println("Goats sorted by Milk Production");
                            ArrayList<Goat> goats = farm.sortGoat();

                            System.out.println("------------------------------------");
                            System.out.format("%-15s %s \n", "Name", "Udder Size");
                            System.out.println("____________________________________");
                            for (Goat goat : goats) {
                                System.out.format("%-15s %s", goat.getName(), goat.getUdder());
                                System.out.println();
                            }

                       
                        }else{
                            System.out.println("Invalid choice\n");
                        } 
                        break;

                    case "q":
                        System.out.println("Thank you for using Farm App");
                        saveDataInFile(farm, "FarmCA/savedDetails.txt");
                        System.exit(0);
                        break;
                    case "Q":
                        System.out.println("Thank you for using Farm App");
                        saveDataInFile(farm, "FarmCA/savedDetails.txt");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }

        }
    }


    //Method to return farm object through choice of user
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
    
        //Manual add farm
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
            Scanner sc = new Scanner(file);

            
            while (sc.hasNext()) {

                String farmName = sc.next();
                int numberOfSheds = sc.nextInt();
                ArrayList<Shed> shedList = new ArrayList<>();
                
                Farm farm = new Farm(farmName, shedList);

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

        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }

        return null;

    }

    // Save data to file using PrintWriter
    public static void saveDataInFile(Farm farm, String path) {

        try {
            File file = new File(path);
            
            // PrintWriter pw = new PrintWriter(file);
            //it is better to use try with resources

            try (PrintWriter pw = new PrintWriter(file)) {
                pw.println(farm);
                for (int i = 0; i < farm.getShedList().size(); i++) {
                    pw.write(farm.getShedList().get(i).getId());
                    pw.println(farm.getShedList().get(i));
                }
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
