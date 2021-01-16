package rtu.klokov.labs.lab10;

public class ObjectArray<T> {
    private Object[] array;

    ObjectArray(int size) {
        array = new Object[size];
    }

    T get(int ind) {
        final T obj = (T) array[ind];
        return obj;
    }

    void set(int ind, final T obj) {
        array[ind] = obj;
    }
}