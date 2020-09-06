package rtu.klokov.labs.lab5;

import java.util.Random;

public class Triangle extends Shape{

    public int []x = new int[3];
    public int []y = new int[3];

    public Triangle(int maxX, int maxY) {
        super();
        Random rand = new Random();
        x[0] = rand.nextInt(maxX);
        y[0] = rand.nextInt(maxY);
        for (int i = 1; i < 3; i++) {
            x[i] = x[i-1] + rand.nextInt(200) - rand.nextInt(200);
            y[i] = y[i-1] + rand.nextInt(200) - rand.nextInt(200);

        }
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }
}
