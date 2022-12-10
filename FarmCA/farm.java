package FarmCA;

import java.util.ArrayList;
import java.util.UUID;

public class Farm {

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

    @Override
    public String toString() {
        return "Owner Name: " + OwnerName + "\n Farm ID: " + farmID ;
    }
}
