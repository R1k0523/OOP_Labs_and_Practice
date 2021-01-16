package rtu.klokov.practics.prac10;

public class Complex {
    private int x;
    private int y;

    public Complex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "" + x + " + i" + y;
    }
}
