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
    
}


