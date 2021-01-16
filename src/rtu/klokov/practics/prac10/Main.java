package rtu.klokov.practics.prac10;

public class Main {
    public static void main(String[] args) {
        ComplexAbstractFactory factory = new ConcreteFactory();
        System.out.println(factory.createComplex());
        System.out.println(factory.CreateComplex(4, 7));
        System.out.println(factory.CreateComplex(5, 2));
        System.out.println(factory.CreateComplex(1, 2));
        System.out.println(factory.CreateComplex(0, 7));
    }
}
