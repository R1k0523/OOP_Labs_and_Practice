package rtu.klokov.labs.lab2;

public class Circle {
    private float coord_x, coord_y, radius;

    public Circle(float coord_x, float coord_y, float radius) {
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.radius = radius;
    }

    public Circle() {
        coord_x = 0;
        coord_y = 0;
        radius = 10;
    }

    public Circle(float radius) {
        this.radius = radius;
        coord_x = 0;
        coord_y = 0;
    }

    public float getCoord_x() {
        return coord_x;
    }

    public void setCoord_x(float coord_x) {
        this.coord_x = coord_x;
    }

    public float getCoord_y() {
        return coord_y;
    }

    public void setCoord_y(float coord_y) {
        this.coord_y = coord_y;
    }

    public void set_xy (float coord_x, float coord_y) {

        this.coord_y = coord_y;
        this.coord_x = coord_x;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String toString() {
        return "Круг. Свойства:" +
                "x=" + coord_x +
                ", y=" + coord_y +
                ", радиус =" + radius + "\n";
    }
}
