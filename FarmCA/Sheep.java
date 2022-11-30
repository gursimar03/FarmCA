package FarmCA;

public class Sheep extends Animal {

    private int woolProduction;

    public Sheep(int id, String name, int woolProduction) {
        super(id, name);
        this.woolProduction = woolProduction;
    }

    public int getWoolProduction() {
        return woolProduction;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "woolProduction=" + woolProduction +
                ", id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }

}
