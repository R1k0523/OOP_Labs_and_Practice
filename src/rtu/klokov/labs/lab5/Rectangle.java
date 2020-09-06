package rtu.klokov.labs.lab5;


import java.util.Random;

public class Rectangle extends Shape {

    public int length, width, x, y;


    public Rectangle(int maxX, int maxY) {
        super();
        Random rand = new Random();
        x = rand.nextInt(maxX);
        y = rand.nextInt(maxY);
        length = rand.nextInt(100)+20;
        width = rand.nextInt(100)+20;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
