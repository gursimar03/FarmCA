package FarmCA;

import java.util.ArrayList;

public class TestApp {

    public static void main(String[] args) {

        DairyCow a = new DairyCow();

        ArrayList<Animal> cows = new ArrayList<>();

        cows.add(a);

        DairyCow a2 = new DairyCow();

        cows.add(a2);

        Shed b = new Shed(cows);

        Farm c = new Farm(1,"myname",b);

        System.out.println(c);

    }

}
