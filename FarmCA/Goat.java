package FarmCA;

public class Goat extends Animal implements Milkable {


    private int udder;

    public Goat() {
        
        //generate random name
        super("Goat " + (int)(Math.random() * 1000));
      //generate a random udder size between 2 to 4
      this.udder = (int)(2 + (Math.random() * 2));
    }

    public Goat(String name) {
        super(name);
        //generate a random udder size between 2 to 4
        this.udder = (int)(2 + (Math.random() * 2));
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
        return "Goat{" +
                ", id=" + getId() +
                '}';
    }

    public double produceMilk() {
        return udder;
    }

}
