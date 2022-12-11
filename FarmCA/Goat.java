package FarmCA;

public class Goat extends Animal implements Milkable, Comparable<Goat> {

    private int udder;

    public Goat() {

        // generate random name
        super("Goat " + (int) (Math.random() * 1000));
        // generate a random udder size between 2 to 4
        this.udder = (int) (2 + (Math.random() * 2));
    }

    public Goat(String name) {
        super(name);
        // generate a random udder size between 2 to 4
        this.udder = (int) (2 + (Math.random() * 2));
    }

    @Override
    public String getId() {

        return super.getId();
    }

    @Override
    public String getName() {

        return super.getName();
    }

    public double getUdder() {
        return udder;
    }

    @Override
    public String toString() {
        return "\nGoat :" +
                "\n >> id=" + getId() +
                "\n >> name=" + getName()
                + "\n >> udder=" + this.udder
                + "\n";
    }

    public double produceMilk() {
        return udder;
    }

    @Override
    public String printAnimalDetails() {
        return ">>>Animal ID: " + getId() + "\n Animal Name: " + getName() + "\n Animal Type: Goat";
    }

    @Override
    public int compareTo(Goat o) {

        if (this.udder > o.udder)
            return 1;
        else if (this.udder < o.udder)
            return -1;
        else
            return 0;

    }

}
