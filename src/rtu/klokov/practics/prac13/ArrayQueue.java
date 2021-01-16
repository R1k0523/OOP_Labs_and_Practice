package rtu.klokov.practics.prac13;


import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayQueue<E> {
    private int size; //заполненность
    private Object[] elements;

    public ArrayQueue() {
        size = 0;
        elements = new Object[0];
    }

    //requires e != null
    //ensures size++, added element
    public void enqueue(E e) { //добавить

        elements = Arrays.copyOf(elements, size+1);
        elements[size] = e;
        size++;
    }

    //requires size > 0
    //ensures first element returned
    public E element() { //вернуть первый
        if (size() > 0)
            return (E) elements[0];
        else
            return null;
    }

    //requires size > 0
    //ensures first element deleted returned
    public E dequeue() { //удалить вернуть
        E response = element();
        elements = Arrays.copyOfRange(elements, 1, size);
        size--;
        return response;
    }

    //requires size != null
    //ensures size returned
    public int size() {
        return size;
    }


    //requires nothing
    //ensures return TRUE if size equals 0, otherwise FALSE
    public boolean isEmpty() {
        return size == 0;
    }


    //requires nothing
    //ensures size = 0, queue was cleared
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }
}
