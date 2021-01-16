package rtu.klokov.practics.prac6;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Student[] students = new Student[5];
        String name, surname;
        int idNumber;
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            name = "Default_Name_" + rand.nextInt(1000);
            surname = "Default_Surname_" + rand.nextInt(1000);
            idNumber = rand.nextInt(100000);
            students[i] = new Student(name, surname, idNumber);
            System.out.println(students[i].toString());
        }
        Sorting.insertionSort(students);
        System.out.println("After sorting:\n");
        for (Student s : students) {
            System.out.println(s.toString());
        }

    }

}
