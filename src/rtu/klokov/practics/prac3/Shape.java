package rtu.klokov.practics.prac3;

public abstract class Shape {

    protected String color;
    protected boolean filled;

    public Shape() {
    }

    public Shape(String color, boolean isFilled) {
        this.color = color;
        this.filled = isFilled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String toString();
}
