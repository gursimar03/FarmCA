package FarmCA;

public class MilkingMachine {


    //Here we have a composition relationship between the MilkingMachine and the MilkTank classes
    //The MilkingMachine class has a reference to the MilkTank class
    //The MilkingMachine class is the owner of the MilkTank class
    //Each MilkingMachine has two MilkTanks, one for cow milk and one for goat milk

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

    //This method is polymorphic because it can be used with different types of animals
    public void milk(Milkable animal){

        //The instanceof operator is used to check if an object is an instance of a class
        if(animal instanceof DairyCow){
            if(this.getCowMilkTank() != null){
                double amount = animal.produceMilk();
                this.cowMilk.addToTank(amount);
            }
            else{
                //The IllegalStateException is a runtime exception if the tank has not been installed
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

    //Tank status method to check the status of the tanks
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


