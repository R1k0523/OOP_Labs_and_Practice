package rtu.klokov.practics.prac13;

import java.util.Arrays;

public class ArrayQueueModule<E> {
    private static int size; //заполненность
    private static Object[] elements;

    public ArrayQueueModule() {
        size = 0;
        elements = new Object[0];
    }


    public static<E> void enqueue(E e) { //добавить
        elements = Arrays.copyOf(elements, size+1);
        elements[size] = e;
        size++;
    }

    public static<E> E element() { //вернуть первый
        if (size() > 0)
            return (E) elements[0];
        else
            return null;
    }

    public static<E> E dequeue() { //удалить вернуть
        E response = element();
        elements = Arrays.copyOfRange(elements, 1, size);
        size--;
        return response;
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }
}
