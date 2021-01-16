package rtu.klokov.practics.prac14;

public class Test {
    public static void main(String[] args){
        Person person1=new Person("Ivanov");
        System.out.println(person1.getInitials());
        Person person=new Person("Ivanov","Alexey","Petrovich");
        System.out.println(person.getInitials());

        Address address =new Address("Russia,  Samarskaya, Syzran, Sovetskaya, 4, 42, 3");
        System.out.println(address);

        String[] shirts=new String[11];
        shirts[0] = "S001,Black Polo Shirt,Black,XL";
        shirts[1] = "S002,Black Polo Shirt,Black,L";
        shirts[2] = "S003,Blue Polo Shirt,Blue,XL";
        shirts[3] = "S004,Blue Polo Shirt,Blue,M";
        shirts[4] = "S005,Tan Polo Shirt,Tan,XL";
        shirts[5] = "S006,Black T-Shirt,Black,XL";
        shirts[6] = "S007,White T-Shirt,White,XL";
        shirts[7] = "S008,White T-Shirt,White,L";
        shirts[8] = "S009,Green T-Shirt,Green,S";
        shirts[9] = "S010,Orange T-Shirt,Orange,S";
        shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";
        Shirt[] shirts1=new Shirt[11];
        for(int i=0;i<11;i++){
            System.out.println(new Shirt(shirts[i]));
        }

        System.out.println(new PhoneNumber("+78005553535"));
        System.out.println(new PhoneNumber("+1018005553535"));
        System.out.println(new PhoneNumber("88005553535"));

    }
}