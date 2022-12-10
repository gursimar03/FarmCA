package FarmCA;

public class MilkTank {

    // MAX_CAPACITY is a constant, so it is declared as final but as user can set custom capacity, it is not static and final
    double MAX_CAPACITY = 2000;
    private double currentCapacity = 0;
    
    public MilkTank(){
        
    }

    public MilkTank(int customCapacity){
        this.MAX_CAPACITY = customCapacity;
    }


    public void setCurrentCapacity(double currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public double getCapacity() {
        return MAX_CAPACITY;
    }

    public double freeSpace() {
        return MAX_CAPACITY - currentCapacity;
    }

    public void addToTank(double amount){

        if (currentCapacity + amount > MAX_CAPACITY){
            currentCapacity = MAX_CAPACITY;
        } else {
            currentCapacity += amount;
        }
    }

    public void getFromTank(double amount){
     
        if (currentCapacity - amount < 0){
            currentCapacity = 0;
        } else {
            currentCapacity -= amount;
        }
    }

    @Override
    public String toString() {
        return "MilkTank{" +
                "\n MAX_CAPACITY=" + MAX_CAPACITY +
                "\n currentCapacity=" + currentCapacity +
                '}';
    }

    // This method is used to add milk to the tank from an animal
    public boolean addToTank(Animal animal) {

        if (animal instanceof Milkable){
            if (freeSpace() >= ((Milkable) animal).produceMilk()){
                addToTank(((Milkable) animal).produceMilk());
                return true;
            }
        }
        return false;
    }
}
