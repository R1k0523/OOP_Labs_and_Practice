package rtu.klokov.practics.prac3;

public class Rectangle extends Shape {

    protected double length, width;

    public Rectangle() {
        length = 10;
        width = 5;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public Rectangle(String color, boolean isFilled, double length, double width) {
        super(color, isFilled);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return length*width;
    }

    @Override
    public double getPerimeter() {
        return length*2 + width*2;
    }

    @Override
    public String toString() {
        return "Прямоугольник" + "\nДлина:" + length + "\nШирина:" + width + "\nЦвет" +  color + (isFilled ? "\nЗакрашенный" : "\nНе закрашенный") + "\nПлощадь: " + getArea() + "\nПериметр: " + getPerimeter();
    }
}
