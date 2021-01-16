package rtu.klokov.practics.prac11;

public class FunctionalChair implements Chair {
    public int sum(int a, int b) {
        return a + b;
    }
    public void sit() {
        System.out.println("You sat on functional chair.");
    }
}
