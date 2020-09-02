package rtu.klokov.labs.lab2;

public class CircleTest {
    public static void main(String[] args) {

        Circle circ1 = new Circle(21);
        Circle circ2 = new Circle();
        Circle circ3 = new Circle(15, 2, 10);
        System.out.println(circ1);
        System.out.println(circ2);
        System.out.println(circ3.getRadius());
        circ1.set_xy(100, 15);
        System.out.println(circ1);

    }


}
