package FarmCA;

public class BeefCow extends Animal {

    private int milkProduction;

    public BeefCow(int id, String name, int milkProduction) {
        super(id, name);
        this.milkProduction = milkProduction;
    }

    public int getMilkProduction() {
        return milkProduction;
    }

    @Override
    public String toString() {
        return "BeefCow{" +
                "milkProduction=" + milkProduction +
                ", id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }

}
