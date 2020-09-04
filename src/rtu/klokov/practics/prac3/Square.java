package rtu.klokov.practics.prac3;

public class Square extends  Rectangle{

    public Square() {
        super();
    }

    public Square(double side) {
        super(side, side);

    }

    public Square(String color, boolean filled, double length, double width) {
        super(color, filled, length, width);
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
