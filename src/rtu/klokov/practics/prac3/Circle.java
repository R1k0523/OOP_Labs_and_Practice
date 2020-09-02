package rtu.klokov.practics.prac3;

public class Circle extends Shape{

    protected double radius;

    public Circle() {
        super();
        radius = 5;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean isFilled, double radius) {
        super(color, isFilled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Круг" + "\nРадиус:" + radius + "\nЦвет" +  color + (isFilled ? "\nЗакрашенный" : "\nНе закрашенный") + "\nПлощадь: " + getArea() + "\nПериметр: " + getPerimeter();
    }
}
