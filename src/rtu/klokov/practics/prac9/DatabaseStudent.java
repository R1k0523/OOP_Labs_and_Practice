package rtu.klokov.practics.prac9;

import java.util.ArrayList;

public class DatabaseStudent {
    private final ArrayList<Student> students=new ArrayList<>();



    public void add(Student student){
        students.add(student);
    }

    public void sort() {
        InsertionSortClass.insertionSort(students);
    }


    public Student find(Student student) throws StudentNotFoundException {
        int index = 0;
        while (index < students.size()) {
            if (students.get(index).compareTo(student)==0)
                return students.get(index);
            else
                index++;
        }
        throw new StudentNotFoundException(student.getName());
    }


    public String toString(){
        String string="";
        for (Student student : students) string += student;
        return string;
    }

    public int getSize() {
        return students.size();
    }

    public Student get(int index) {
        return students.get(index);
    }
}
