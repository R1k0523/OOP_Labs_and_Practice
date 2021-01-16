package rtu.klokov.practics.prac10;

public class ConcreteFactory implements ComplexAbstractFactory {

    public Complex createComplex() {
        return new Complex(0, 0);
    }

    public Complex CreateComplex(int real, int image) {
        return new Complex(real, image);
    }
}
