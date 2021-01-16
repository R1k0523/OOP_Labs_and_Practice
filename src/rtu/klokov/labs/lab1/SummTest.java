package rtu.klokov.labs.lab1;


import static rtu.klokov.labs.lab1.Summator.*;

public class SummTest {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        System.out.println(sum_do_while(a));
        System.out.println(sum_for(a));
        System.out.println(sum_while(a));
    }
}
