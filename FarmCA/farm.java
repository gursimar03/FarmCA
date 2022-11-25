package FarmCA;

public class farm {

    private int id;
    private String OwnerName;
    private String shed;

    public int numberOfFarms;

    public farm() {
        System.out.print("sadsadasd");
    }

    public farm(int id, String OwnerName, String shed) {

        this.id = id;
        this.OwnerName = OwnerName;
        this.shed = shed;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public String getShed() {
        return shed;
    }

    public void setShed(String shed) {
        this.shed = shed;
    }

    public String getOwnerName() {
        return OwnerName;
    }
}
