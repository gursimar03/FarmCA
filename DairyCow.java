package FarmCA;

public class DairyCow {

    private int id;
    private String name;
    private double udder;

    public DairyCow() {

        String randomName = "Cow" + (int)(Math.random() * 1000);

        this.name = randomName;
        this.id = (int)(Math.random() * 1000);
        this.udder = randomUdder();
    }

 

    public DairyCow(String name){
        this.name = name;
        this.id = (int)(Math.random() * 1000);
        this.udder = randomUdder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCapacity() {
        return udder;
    }

    public void setUdder(double udder) {
        this.udder = udder;
    }

    @Override
    public String toString() {
        return "Cow{" + "id=" + id + ", name=" + name + ", udder=" + udder + '}';
    }


    public double randomUdder(){
     
        double udderSize = (Math.random() * 20) + 20;        
        return udderSize;
    }
    
}
