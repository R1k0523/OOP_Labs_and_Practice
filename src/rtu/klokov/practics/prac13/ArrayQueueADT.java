package rtu.klokov.practics.prac13;

import java.util.Arrays;
import java.util.List;

public class ArrayQueueADT<E> {
    private int size = 0; //заполненность
    private E[] elements;


    public ArrayQueueADT(E[] elements) { //добавить
        this.elements = elements;
        size = elements.length;
    }
    public void enqueue(E e) {
        boolean has_no_empty = true;
        for (int i = 0 ; i < size; i++) {
            if (elements[i] == null) {
                elements[i] = e;
                has_no_empty = false;
                break;
            }
        }
        if (has_no_empty) {
            elements = Arrays.copyOf(elements, elements.length + 1);
            elements[size] = e;
            size++;
        }
    }

    public E element() { //вернуть первый
        if (size() > 0)
            return elements[0];
        else
            return null;
    }

    public E dequeue() { //удалить вернуть
        if (size() == 0)
            throw new NullPointerException();
        E response = element();
        elements = Arrays.copyOfRange(elements, 1, elements.length);
        size--;
        return response;
    }

    public int size() {
            return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }
}
