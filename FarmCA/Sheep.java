package FarmCA;

public class Sheep extends Animal {

    public Sheep(int id, String name) {
        super(name);

    }

    public Sheep() {
        
        //generate random name
        super("Sheep " + (int)(Math.random() * 1000));

    }

    public Sheep(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Sheep{" +
                ", id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }

}
