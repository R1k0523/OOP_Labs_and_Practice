package rtu.klokov.labs.lab1;

public class Summator {
    static int sum_for (int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
    static int sum_while (int[] arr) {
        int sum = 0;
        int i = 0;
        while (i < arr.length) {
            sum += arr[i];
            i++;
        }
        return sum;

    }
    static int sum_do_while(int[] arr) {
        int sum = 0;
        int i = 0;
        do {
            sum += arr[i];
            i++;
        } while (i < arr.length);

        return sum;

    }

}
