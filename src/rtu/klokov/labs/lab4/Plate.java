package rtu.klokov.labs.lab4;

public class Plate extends Dish {

    private boolean hasPattern;
    private int depth, radius;

    public Plate(String color, String material, int size, boolean isClean, boolean hasPattern, int depth, int radius) {
        super(color, material, size, isClean);
        this.hasPattern = hasPattern;
        this.depth = depth;
        this.radius = radius;
    }

    public Plate(boolean hasPattern, int depth, int radius) {
        super();
        this.hasPattern = hasPattern;
        this.depth = depth;
        this.radius = radius;
    }

    public Plate(String material, int size, boolean hasPattern, int depth, int radius) {
        super(material, size);
        this.hasPattern = hasPattern;
        this.depth = depth;
        this.radius = radius;
    }

    public boolean hasPattern() {
        return hasPattern;
    }

    public void setPattern(boolean hasPattern) {
        this.hasPattern = hasPattern;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String toString() {
        return "Свойства ТАРЕЛКИ\n" +
                " Цвет: " + getColor() + ' ' +
                "\n Материал: " + getMaterial() + ' ' +
                "\n Размер: " + getSize() +
                "\n Посуда " + (isClean() ? "чистая" : "грязная") +
                "\n Узор " + (hasPattern ? "присутствует" : "отсутствует") +
                "\n Глубина " + depth +
                "\n Радиус " + radius;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
