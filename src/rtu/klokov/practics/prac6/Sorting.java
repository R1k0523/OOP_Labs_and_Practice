package rtu.klokov.practics.prac6;

public class Sorting {

    public static void insertionSort(Student[] students) {
        for (int left = 0; left < students.length; left++) {
            Student value = students[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value.getIdNumber() < students[i].getIdNumber()) {
                    students[i + 1] = students[i];
                } else {
                    break;
                }
            }
            students[i + 1] = value;
        }
    }
}
