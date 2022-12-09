package FarmCA;

import java.util.ArrayList;

public class TestApp {

    public static void main(String[] args) {

        DairyCow a = new DairyCow();

        ArrayList<Animal> cows = new ArrayList<>();
        ArrayList<Animal> goats = new ArrayList<>();

        Goat aGoat = new Goat("goat");
        goats.add(aGoat);


        cows.add(a);

        DairyCow a2 = new DairyCow();

        ArrayList<Shed> shed = new ArrayList<>();
        shed.add(new Shed(cows));
        
        cows.add(a2);
        
        Shed b = new Shed(goats);
        shed.add(b);

        Farm c = new Farm(1,"myname",shed);

        MilkingMachine m = new MilkingMachine();

        shed.get(0).setMilkingMachine(m);

        shed.get(0).installTankForCow(new MilkTank());

        shed.get(0).milkAnimals();
        
        System.out.println(m);

        MilkingMachine m2 = new MilkingMachine();

        shed.get(1).setMilkingMachine(m2);
        shed.get(1).installTankForGoat(new MilkTank());
        shed.get(1).milkAnimals();

        System.out.println(m2);

        System.out.println(c);

    }

}
