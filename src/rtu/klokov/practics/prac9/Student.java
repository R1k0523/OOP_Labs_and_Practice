package rtu.klokov.practics.prac9;

public class Student implements Comparable<Student>{
    private String name;
    private int Id;
    private double gpa;

    public Student(String name, int id, double gpa) {
        this.name = name;
        Id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String toString(){
        return "№: "+this.getId()+" ФИО: "+this.getName()+" Средний балл: "+this.getGpa()+"\n";
    }

    @Override
    public int compareTo(Student o) {
        if(this.getName().equals(o.getName()))return 0;
        return (int)((this.getGpa()-o.getGpa())*100);
    }
}
