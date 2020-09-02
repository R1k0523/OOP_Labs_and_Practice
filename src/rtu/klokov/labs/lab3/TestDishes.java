package rtu.klokov.labs.lab3;


public class TestDishes {

    public static void main(String[] args) {

        //Dish dish1 = new Dish(); test, that I can't create abstract class
        Plate plate = new Plate("red", "glass", 20, true, false, 5, 15);
        Cup cup = new Cup(300);
        cup.setClean(false);
        if (plate.hasPattern()) {
            System.out.println("Тарелка имеет узор");
        } else {
            cup.setCapacity(100);
        }

        System.out.println(cup.toString());
        System.out.println(plate.toString());

    }

}
