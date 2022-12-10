package FarmCA;

public class MilkingMachine {

    private MilkTank cowMilk;
    private MilkTank goatMilk;
    private String name;
  
    public MilkingMachine(){

    }
    
    public MilkingMachine(String name){
        this.name = name;
    }

    
    public void setCowMilk(MilkTank cowMilk) {
        this.cowMilk = cowMilk;
    }
    
    public void setGoatMilk(MilkTank goatMilk) {
        this.goatMilk = goatMilk;
    }

    public MilkTank getCowMilkTank() {
        return cowMilk;
    }

    public MilkTank getGoatMilkTank() {
        return goatMilk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void emptyMilkTanks(){
        this.cowMilk.setCurrentCapacity(0);;
        this.goatMilk.setCurrentCapacity(0);
    }

    public void milk(Milkable animal){

        if(animal instanceof DairyCow){
            if(this.getCowMilkTank() != null){
                double amount = animal.produceMilk();
                this.cowMilk.addToTank(amount);
            }
            else{
                throw new IllegalStateException("No tank has been installed");
            }
        }
        else if(animal instanceof Goat){
            if(this.getGoatMilkTank() != null){
                double amount = animal.produceMilk();
                this.goatMilk.addToTank(amount);
            }
            else{
                throw new IllegalStateException("No tank has been installed");
            }
        }
        else{
            throw new IllegalArgumentException("This animal cannot be milked");
        }
    }

    public void tankStatus(){

        if(this.getCowMilkTank() != null){
            System.out.println("Cow tank: " + this.getCowMilkTank() + "L");
        }
        else{
            System.out.println("Cow tank: No tank installed");
        }

        if(this.getGoatMilkTank() != null){
            System.out.println("Goat tank: " + this.getGoatMilkTank() + "L");
        }
        else{
            System.out.println("Goat tank: No tank installed");
        }

    }

    @Override
    public String toString() {
        return "MilkingMachine{" +
                "\ncowMilk=" + cowMilk +
                "\n goatMilk=" + goatMilk +
                ", name='" + name + '\'' +
                '}';
    }
    
}


