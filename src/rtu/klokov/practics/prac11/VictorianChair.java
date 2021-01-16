package rtu.klokov.practics.prac11;

public class VictorianChair implements Chair {
    int age;

    public VictorianChair(int age) {
        this.age = age;
    }

    public void sit() {
        System.out.println("You sat on victorian chair.");
    }
    public int getAge() {
        return age;
    }
}
