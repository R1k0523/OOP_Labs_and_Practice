package rtu.klokov.labs.lab10;

import rtu.klokov.labs.lab6.Application;

import java.util.ArrayList;

public class TestArrayToArrayList {
    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            array[i] = i+10;
        }
        ArrayToArrayList(array, arrayList);

        String[] array2 = new String[10];
        ArrayList<String> arrayList2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            array2[i] = "string"+i;
        }
        ArrayToArrayList(array2, arrayList2);
        for (int i = 0; i < 10; i++) {
            System.out.println(arrayList.get(i));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(arrayList2.get(i));
        }

    }
    public static <E> void ArrayToArrayList(E[] arr, ArrayList<E> list) {
        for (E e : arr) list.add(e);
    }
}
