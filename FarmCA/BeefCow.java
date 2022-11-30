package FarmCA;

public class BeefCow extends Animal {

    private int milkProduction;

    public BeefCow(int id, String name) {
        super(id, name);
    }

    public int getMilkProduction() {
        return milkProduction;
    }

    @Override
    public String toString() {
        return "BeefCow{" +
                ", id=" + getId() +
                '}';
    }
}
