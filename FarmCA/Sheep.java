package FarmCA;

public class Sheep extends Animal {

    private int pedgree;
    private int weight;
    private int age;

    public Sheep(int id, String name, int pedgree, int weight, int age) {
        super(name);
        this.pedgree = pedgree;
        this.weight = weight;
        this.age = age;
    }

    public Sheep(int id, String name) {
        super(name);

    }

    public int getPedgree() {
        return pedgree;
    }

    public void setPedgree(int pedgree) {
        this.pedgree = pedgree;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sheep() {

        // generate random name
        super("Sheep " + (int) (Math.random() * 1000));

    }

    public Sheep(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "\nGoat: " +
                "\n >> id=" + getId() +
                "\n >> name=" + getName()
                + "\n >> pedgree=" + this.pedgree
                + "\n >> weight=" + this.weight;
    }

    @Override
    public String printAnimalDetails() {
        // TODO Auto-generated method stub
        return null;
    }

}
