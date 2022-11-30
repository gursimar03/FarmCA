package FarmCA;

public class Sheep extends Animal {

    public Sheep(int id, String name) {
        super(id, name);

    }

    @Override
    public String toString() {
        return "Sheep{" +
                ", id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }

}
