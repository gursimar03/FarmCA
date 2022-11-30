package FarmCA;

public class Goat extends Animal implements Milkable {

    private int milkProduction;

    public Goat(int id, String name, int milkProduction) {
        super(id, name);
        this.milkProduction = milkProduction;
    }

    public int getMilkProduction() {
        return milkProduction;
    }

    @Override
    public String toString() {
        return "Goat{" +
                "milkProduction=" + milkProduction +
                ", id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }

}
