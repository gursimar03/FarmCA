package FarmCA;

public class DairyCow extends Animal implements Milkable {

    private int milkProduction;

    public DairyCow(int id, String name, int milkProduction) {
        super(id, name);
        this.milkProduction = milkProduction;
    }

    public int getMilkProduction() {
        return milkProduction;
    }

    @Override
    public String toString() {
        return "DairyCow{" +
                "milkProduction=" + milkProduction +
                ", id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }

}
