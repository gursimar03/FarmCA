package FarmCA;

public class Goat extends Animal implements Milkable {


    private double udder;

    public Goat(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Goat{" +
                ", id=" + getId() +
                '}';
    }

}
