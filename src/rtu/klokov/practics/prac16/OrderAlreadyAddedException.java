package rtu.klokov.practics.prac16;

public class OrderAlreadyAddedException extends IllegalAccessException {
    public OrderAlreadyAddedException(String error) {
        super(error);
    }
}
