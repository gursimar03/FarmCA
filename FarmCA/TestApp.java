package FarmCA;

import java.util.ArrayList;

public class TestApp {

    public static void main(String[] args) {

        DairyCow a = new DairyCow(1, "Bessie", 20.0);

        ArrayList<Animal> cows = new ArrayList<>();

        cows.add(a);

        Shed b = new Shed(cows);

    }

}
