package rtu.klokov.labs.lab16;

public class OrderAlreadyAddedException extends IllegalAccessException {
    public OrderAlreadyAddedException(String error) {
        super(error);
    }
}
