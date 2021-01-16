package rtu.klokov.practics.prac16;



import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MenuItem implements Comparable<MenuItem>{
    private int cost;
    private String name;
    private String description;

    public MenuItem(int cost, String name, String description) {
        if (cost < 0 || name.isEmpty() || description.isEmpty())
            throw new IllegalArgumentException("Ошибка, цена меньше нуля, название или описание пустое.\nЦена: " +
                    cost + "\nНазвание: " + name + "\nОписание: " + description);

        this.cost = cost;
        this.name = name;
        this.description = description;
    }
    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MenuItem)) return false;//проверка на соответствие типов
        MenuItem menuItem = (MenuItem) o;
        return cost == menuItem.cost
                && name.equals(menuItem.name)
                && description.equals(menuItem.description);
    }



    public int hashCode() {
        return Objects.hash(cost, name, description);
    }

    public int compareTo(@NotNull MenuItem o) {
        if (getCost() == o.getCost())
            return 0;
        return (getCost() < o.getCost() ? -1 : 1);
    }
}
