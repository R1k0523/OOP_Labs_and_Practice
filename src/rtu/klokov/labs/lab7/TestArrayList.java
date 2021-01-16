package rtu.klokov.labs.lab7;

import java.util.ArrayList;
import java.util.Random;

public class TestArrayList {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            arr.add(random.nextInt(400));
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(arr.get(i));
        }
        arr.add(400);
        System.out.println(arr.contains(400));
        arr.sort(Integer::compareTo);

        for (int i = 0; i < 5; i++) {
            System.out.println(arr.get(i));
        }
        Object[] arr2 = arr.toArray();

        for (Object i : arr2) {
            System.out.println(i);
        }
        System.out.println("\n\n\nClear method test:");
        arr.clear();
        for (int i : arr) {
            System.out.println(i);
        }


    }
}
