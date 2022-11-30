package FarmCA;

public class DairyCow extends Animal implements Milkable {

    String name;
    int id;
    double udder;

    public DairyCow(int id, String name, double udder) {
        super(id, name);

        this.udder = udder;
    }

}
