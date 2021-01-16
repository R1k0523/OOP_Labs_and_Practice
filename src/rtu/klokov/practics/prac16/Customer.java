package rtu.klokov.practics.prac16;

public final class Customer {
    public static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer("Неизвестный", "покупатель", 100, Address.EMPTY_ADDRESS);
    public static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer("Неизвестный", "покупатель", 0, Address.EMPTY_ADDRESS);
    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
