package rtu.klokov.practics.prac6;

public class Sorting {

    public static void insertionSort(Comparable[] comparables) {
        for (int left = 0; left < comparables.length; left++) {
            Comparable value = comparables[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value.compareTo(comparables[i]) < 0) { //если ID самого левого студента меньше
                    comparables[i + 1] = comparables[i];
                } else {
                    break;
                }
            }
            comparables[i + 1] = value;
        }
    }
}
