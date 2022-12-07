package FarmCA;

public class DairyCow extends Animal implements Milkable {

    double udder;

    public DairyCow() {
        
        //generate random name
        super("Daisy " + (int)(Math.random() * 1000));

        //udder capacity between 20 to 40 random
        this.udder = (Math.random() * 20) + 20;
    }

    public Cow(String name) {

        super(name);
        //udder capacity between 20 to 40 random
        this.udder = (Math.random() * 20) + 20;
    }

    public String getName(){
        return name;
    }
    
    public double getCapacity() {
        return udder;
    }



}
