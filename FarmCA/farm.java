package FarmCA;

import java.util.ArrayList;
import java.util.UUID;

public class Farm {


    //Considering that each farm has a unique ID and owner name with multiple sheds

    enum AnimalTypes {
        DairyCow, Goat, Sheep, BeefCow
    }
    

    private String farmID;
    private String OwnerName;
    private ArrayList<Shed> shedList;

    public Farm(String farmID, String OwnerName , ArrayList<Shed> shed) {
        this.farmID = farmID;
        this.OwnerName = OwnerName;
        this.shedList = shed;
    }

    public Farm(String OwnerName , ArrayList<Shed> shed) {
        this.farmID = UUID.randomUUID().toString();
        this.OwnerName = OwnerName;
        this.shedList = shed;
    }

    public Farm() {
    }

    public String getFarmID() {
        return farmID;
    }

    public void setFarmID(String farmID) {
        this.farmID = farmID;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public ArrayList<Shed> getShedList() {
        return shedList;
    }

    public void addShed(Shed shed) {
        this.shedList.add(shed);
    }

    public void printFarmDetails() {
        System.out.println("Farm ID: " + farmID);
        System.out.println("Owner Name: " + OwnerName);
        for (Shed shed : shedList) {
            shed.printShedDetails();
        }
    }

    public void removeShed(Shed shed) {
        this.shedList.remove(shed);    
    }

    public ArrayList<DairyCow> sortDairyCow() {

        ArrayList<Animal> animalList = new ArrayList<>();

        for (Shed shed : shedList) {
            animalList.addAll(shed.getHerd());
        }

        //sort by udder size
        ArrayList<DairyCow> dairyCowList = new ArrayList<>();

        for (Animal dairyCow : animalList) {
            if(dairyCow instanceof DairyCow){
                dairyCowList.add((DairyCow) dairyCow);
            }
        }

        //sort dairyCowList by udder size
        for (int i = 0; i < dairyCowList.size(); i++) {
            for (int j = 0; j < dairyCowList.size() - 1; j++) {
                if (dairyCowList.get(j).getUdderSize() > dairyCowList.get(j + 1).getUdderSize()) {
                    DairyCow temp = dairyCowList.get(j);
                    dairyCowList.set(j, dairyCowList.get(j + 1));
                    dairyCowList.set(j + 1, temp);
                }
            }
        }

        return dairyCowList;
    }

    

    public ArrayList<Goat> sortGoat() {

        ArrayList<Animal> animalList = new ArrayList<>();

        for (Shed shed : shedList) {
            animalList.addAll(shed.getHerd());
        }

        //sort by udder size
        ArrayList<Goat> goatsList = new ArrayList<>();

        for (Animal dairyCow : animalList) {
            if(dairyCow instanceof Goat){
                goatsList.add((Goat) dairyCow);
            }
        }

        //sort dairyCowList by udder size
        for (int i = 0; i < goatsList.size(); i++) {
            for (int j = 0; j < goatsList.size() - 1; j++) {
                if (goatsList.get(j).getUdder() > goatsList.get(j + 1).getUdder()) {
                    Goat temp = goatsList.get(j);
                    goatsList.set(j, goatsList.get(j + 1));
                    goatsList.set(j + 1, temp);
                }
            }
        }

        return goatsList;
    }

    public void avaiableAnimalTypes() {
        for (AnimalTypes animalType : AnimalTypes.values()) {
            System.out.print("\n  >>>"+animalType);
        }
    }

    @Override
    public String toString() {
        return "Owner Name: " + OwnerName + "\n Farm ID: " + farmID ;
    }

}
