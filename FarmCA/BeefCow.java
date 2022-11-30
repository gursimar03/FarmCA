package FarmCA;

public class BeefCow extends Animal {


    public BeefCow(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "BeefCow{" +
                ", id=" + getId() +
                '}';
    }
}
