package rtu.klokov.practics.prac8;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Класс для реализации списка ожидания, реализующий интерфейс {@link rtu.klokov.practics.prac8.IWaitList}
 * @author Клоков Сергей
 * @version 1.0
 * @param <E> - ожидающий элемент
 */
public class WaitList<E> implements IWaitList<E> {
    /** Поле список ожидания */
    protected ConcurrentLinkedQueue<E> content;

    /**
     * Конструктор по умолчанию, вызываемый при создании нового объекта
     * @see WaitList#WaitList(ConcurrentLinkedQueue<E>)
     */
    public WaitList() {
        content = new ConcurrentLinkedQueue<E>();
    }

    /**
     * Конструктор - создание нового объекта
     * @param content - список ожидания
     * @see WaitList#WaitList()
     */
    public WaitList(ConcurrentLinkedQueue<E> content) {
        this.content = content;
    }

    /**
     * Метод, возвращающий данные об объекте в строковом формате
     * @return - данные об объекте в строковом формате
     */
    public String toString() {
        return "WaitList{" +
                "content=" + content +
                '}';
    }
    /**
     * Метод добавления нового элемента
     * @param element - добавляемый элемент
     */
    public void add(E element) {
        content.add(element);
    }

    /**
     * Метод извлечения первого элемента в очереди
     * @return возвращает удаленный элемент
     */
    public E remove() {
        return content.remove();
    }

    /**
     * Метод проверки, есть ли элемент в очереди
     * @param element - проверяемый элемент
     * @return true - если элемент присутствует, false - отсутствует
     */
    public boolean contains(E element) {
        return content.contains(element);
    }

    /**
     * Метод проверки, есть ли элемент в очереди
     * @param c - коллекция проверяемых элементов
     * @return true - если элемент присутствует, false - отсутствует
     */
    public boolean containsAll(Collection c) {
        return content.containsAll(c);
    }

    /**
     * Проверка, пустая ли очередь
     * @return true - если элемент присутствует, false - отсутствует
     */
    public boolean isEmpty() {
        return content.isEmpty();
    }
}
