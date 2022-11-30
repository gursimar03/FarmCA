package FarmCA;

import java.util.ArrayList;

public class TestApp {

    public static void main(String[] args) {

        DairyCow a = new DairyCow(0, null, 0);

        ArrayList<Animal> cows = new ArrayList<>();

        cows.add(a);

        Shed b = new Shed(cows);

    }

}
