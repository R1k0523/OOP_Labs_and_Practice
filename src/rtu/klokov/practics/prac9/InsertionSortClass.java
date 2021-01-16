package rtu.klokov.practics.prac9;

import java.util.ArrayList;

public class InsertionSortClass {

    public static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> comparables) {
        for (int left = 0; left < comparables.size(); left++) {
            T value = comparables.get(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value.compareTo(comparables.get(i)) > 0) { //если ID самого левого студента меньше
                    comparables.set(i + 1, comparables.get(i));
                } else {
                    break;
                }
            }
            comparables.set(i + 1, value);
        }
    }
}
