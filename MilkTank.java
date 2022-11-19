package FarmCA;

public class MilkTank {

    private int id;
    private double capacity;

    final double MAX_CAPACITY = 2000;

    public MilkTank() {
        this.id = (int)(Math.random() * 1000);
        this.capacity = MAX_CAPACITY;
    }

    public MilkTank(int id, double capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public MilkTank(double capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCapacity() {
        return capacity;
    }

    public void freeSpace(){
        this.capacity = 0;
    }

    public void addToTank(double milk){
        this.capacity += milk;
    }

    public void getFromTank(double milk){
        this.capacity -= milk;
    }
    
    @Override
    public String toString() {
        return "MilkTank{" + "id=" + id + ", capacity=" + capacity + '}';
    }


}
