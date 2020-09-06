package rtu.klokov.labs.lab5;

import java.awt.*;
import java.util.Random;

public abstract class Shape {

    public Color color;
    public boolean filled;

    public Shape() {
        Random rand = new Random();
        color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
        filled = true;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}
