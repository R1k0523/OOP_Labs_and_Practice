package rtu.klokov.labs.lab5;

import java.util.Random;

public class Ellipse extends Shape {

    public int axisA, axisB;
    public int x, y;

    public Ellipse(int maxX, int maxY) {
        super();
        Random rand = new Random();

        x = rand.nextInt(maxX);
        y = rand.nextInt(maxY);
        axisA = rand.nextInt(200)+20;
        axisB = rand.nextInt(200)+20;
    }

    public int getAxisA() {
        return axisA;
    }

    public void setAxisA(int axisA) {
        this.axisA = axisA;
    }

    public int getAxisB() {
        return axisB;
    }

    public void setAxisB(int axisB) {
        this.axisB = axisB;
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
