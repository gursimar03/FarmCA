package FarmCA;

public class Farm {

    private int farmID;
    private String OwnerName;

    Shed shed = new Shed();

    public Farm(int farmID, String OwnerName) {
        this.farmID = farmID;
        this.OwnerName = OwnerName;
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
        this.shed = shed;
    }

    public void printFarmDetails() {
        System.out.println("Farm ID: " + farmID);
        System.out.println("Owner Name: " + OwnerName);
        System.out.println("Shed Details: ");
        shed.printShedDetails();
    }
}
