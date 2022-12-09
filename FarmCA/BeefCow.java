package FarmCA;

public class BeefCow extends Animal {


    public BeefCow(int id, String name) {
        super(name);
    }

    public BeefCow() {
        
        //generate random name
        super("BeefCow " + (int)(Math.random() * 1000));

    }

    public BeefCow(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "BeefCow{" +
                ", id=" + getId() +
                '}';
    }
}
