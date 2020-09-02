package rtu.klokov.labs.lab4;

public class Cup extends Dish {

    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Cup(String color, String material, int size, boolean isClean, int capacity) {
        super(color, material, size, isClean);
        this.capacity = capacity;
    }

    public Cup(int capacity) {
        super();
        this.capacity = capacity;
    }

    public Cup(String material, int size, int capacity) {
        super(material, size);
        this.capacity = capacity;
    }

    public Cup() {
        super();
        capacity = 300;
    }

    @Override
    public int getPrice() {
        return price;
    }

}
