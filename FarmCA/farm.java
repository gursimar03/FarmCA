package FarmCA;

import java.util.ArrayList;

public class Farm {

    private int farmID;
    private String OwnerName;
    private ArrayList<Shed> shedList;

    public Farm(int farmID, String OwnerName , ArrayList<Shed> shed) {
        this.farmID = farmID;
        this.OwnerName = OwnerName;
        this.shedList = shed;
    }

    public Farm() {
    }

    public int getFarmID() {
        return farmID;
    }

    public void setFarmID(int farmID) {
        this.farmID = farmID;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public void addShed(Shed shed) {
        this.shedList.add(shed);
    }

    public void printFarmDetails() {
        System.out.println("Farm ID: " + farmID);
        System.out.println("Owner Name: " + OwnerName);
        System.out.println("Shed Details: ");
        for (Shed shed : shedList) {
            shed.printShedDetails();
        }
    }

    @Override
    public String toString() {
        return "Farm{" +
                "farmID=" + farmID +
                ", OwnerName='" + OwnerName + '\'' +
                
                '}';
    }
}
