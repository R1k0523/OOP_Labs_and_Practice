package rtu.klokov.practics.prac3;

public class Square extends  Rectangle{

    public Square() {
    }

    public Square(double length, double width) {
        super(length, width);
    }

    public Square(String color, boolean isFilled, double length, double width) {
        super(color, isFilled, length, width);
    }

    @Override
    public double getWidth() {
        return super.getWidth();
    }

    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        setLength(side);
    }

    public double getSide() {
        return width;
    }

    public void setSide(double side) {
        length = side;
        width = side;
    }
}
