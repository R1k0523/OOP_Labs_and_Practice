package rtu.klokov.labs.lab4;


public class TestPriceable {

    public static void main(String[] args) {

        Plate plate = new Plate("blue", "metal", 20, true, false, 5, 15);
        Cup cup = new Cup(250);
        cup.setClean(false);
        System.out.println(cup.toString());
        System.out.println(plate.toString());
        if (cup.getPrice() != 0) {
            System.out.println("Стоимость набора (Чашка+тарелка): " + (cup.getPrice() + plate.getPrice()));
        } else {
            System.out.println("Стоимость чашки: " + cup.getPrice());
        }
    }

}
