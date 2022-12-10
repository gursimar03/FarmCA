package FarmCA;

public class DairyCow extends Animal implements Milkable {

    private int udder;

    public DairyCow() {
        
        //generate random name
        super("Daisy " + (int)(Math.random() * 1000));

        //udder capacity between 20 to 40 random
        this.udder = (int) (Math.random() * 20) + 20;
    }

    public DairyCow(String name) {
        
        //generate random name
        super(name);

        //udder capacity between 20 to 40 random
        this.udder = (int) (Math.random() * 20) + 20;
    }

    public String getName(){
        return name;
    }
    
    public double getCapacity() {
        return udder;
    }

    public double produceMilk() {
        return udder;
    }

    @Override
    public String toString() {
        return "\nDairyCow :" +
                "\n >> id=" + getId() +
                "\n >> name=" + getName()
                + "\n >> udder=" + this.udder
                + "\n";
    }

    @Override
    public String printAnimalDetails() {
        return ">>>Animal ID: " + getId() + "\n Animal Name: " + getName() + "\n Animal Type: DairyCow";
    }


}
