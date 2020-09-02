package rtu.klokov.labs.lab4;

public abstract class Dish implements Priceable{
    private String color, material;
    private int size;
    private boolean isClean;

    public Dish(String color, String material, int size, boolean isClean) {
        this.color = color;
        this.material = material;
        this.size = size;
        this.isClean = isClean;
    }

    public Dish() {
        color = "white";
        material = "plastic";
        size = 20;
        isClean = true;
    }

    public Dish(String material, int size) {
        color = "white";
        this.material = material;
        this.size = size;
        isClean = true;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public void washDish() {
        isClean = true;
    }

    public String toString() {
        return "Свойства посуды\n" +
                " Цвет: " + color + ' ' +
                "\n Материал: " + material + ' ' +
                "\n Размер: " + size +
                "\n Посуда " + (isClean ? "чистая" : "грязная");
    }
}
