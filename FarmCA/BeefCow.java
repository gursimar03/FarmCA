package FarmCA;

public class BeefCow extends Animal implements Comparable<BeefCow> {

    private int pedgree;
    private int weight;
    private int age;

    public BeefCow(int id, String name) {
        super(name);
    }

    public BeefCow(int id, String name, int pedgree, int weight, int age) {
        super(name);
        this.pedgree = pedgree;
        this.weight = weight;
        this.age = age;
    }

    public int getPedgree() {
        return pedgree;
    }

    public void setPedgree(int pedgree) {
        this.pedgree = pedgree;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public BeefCow() {
        
        //generate random name
        super("BeefCow " + (int)(Math.random() * 1000));

    }

    public BeefCow(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "\nBeefCow: " +
                "\n >> id=" + getId() +
                "\n >> name=" + getName()
                + "\n >> pedgree=" + this.pedgree
                + "\n >> weight=" + this.weight;
    }

    @Override
    public String printAnimalDetails() {
        return ">>>Animal ID: " + getId() + "\n Animal Name: " + getName() + "\n Animal Type: BeefCow";
    }

    @Override
    public int compareTo(BeefCow o) {
        
        if (this.getWeight() > o.getWeight()) {
            return 1;
        } else if (this.getWeight() < o.getWeight()) {
            return -1;
        }

        return 0;
    }

    
}
