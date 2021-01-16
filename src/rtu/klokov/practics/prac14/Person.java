package rtu.klokov.practics.prac14;

public class Person {
    String name;
    String fathersName;
    String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Person(String name, String fathersName, String surname) {
        this.surname = surname;
        this.name = name;
        this.fathersName = fathersName;
    }

    public Person(String surname) {
        this.surname = surname;
    }

    public Person() {
        this.surname = "Ivanov";
        this.name = "Ivan";
        this.fathersName = "Ivanovich";
    }

    public String getInitials(){
        String string= "%s";
        if(name!=null && !name.isEmpty())
            string+=" %.1s.";
        if(fathersName !=null && !fathersName.isEmpty())
            string+=" %.1s.";
        return String.format(string, surname, name, fathersName);
    }
}
