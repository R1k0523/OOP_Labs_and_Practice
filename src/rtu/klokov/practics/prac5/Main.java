package rtu.klokov.practics.prac5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(max());
    }

    private static int max() {
        Scanner scan = new Scanner(System.in);
        int next = scan.nextInt();
        if (next == 0) return 0;
        return (Math.max(next, max()));
    }

}
