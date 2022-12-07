package FarmCA;

public class DairyCow extends Animal implements Milkable {

    private String name;
    double udder;

    public DairyCow(String name) {

        

        super(name);
        //udder capacity between 20 to 40 random
        this.udder = (Math.random() * 20) + 20;
    }

    public double getUdder() {
        return udder;
    }

}
