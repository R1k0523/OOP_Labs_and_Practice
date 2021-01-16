package rtu.klokov.practics.prac6;


public class Student implements Comparable<Student>{
    private String name, surname;
    private int idNumber;

    public Student(String name, String surname, int idNumber) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
    }

    public Student() {
        name = "Default_Name";
        surname = "Default_Surname";
        idNumber = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String toString() {
        return  "Name: " + name +
                ", Surname = " + surname  +
                ", ID = " + idNumber + "\n";
    }

    public int compareTo(Student o) {
        if (getIdNumber() == o.getIdNumber())
            return 0;
        return (getIdNumber() > o.getIdNumber() ? 1 : -1);
    }
}
