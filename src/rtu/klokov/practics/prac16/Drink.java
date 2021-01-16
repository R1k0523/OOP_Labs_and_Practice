package rtu.klokov.practics.prac16;

public final class Drink extends MenuItem implements Alcoholable {
    private final double alcoholVol;
    private final DrinkTypeEnum type;

    public Drink(int cost, String name, String description, double alcoholVol, DrinkTypeEnum type) {
        super(cost, name, description);
        this.alcoholVol = alcoholVol;
        this.type = type;
    }

    public boolean isAlcoholicDrink() {
        return alcoholVol > 0;
    }

    public double getAlcoholVol() {
        return alcoholVol;
    }

    public DrinkTypeEnum getType() {
        return type;
    }
}
