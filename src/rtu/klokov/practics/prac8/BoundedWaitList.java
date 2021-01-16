package rtu.klokov.practics.prac8;

/**
 * Класс, наследуемый от {@link WaitList}, ограниченный по размеру
 * @author Клоков Сергей
 * @version 1.0
 * @param <E> - ожидающий элемент
 */
public class BoundedWaitList<E> extends WaitList<E> {
    /** Поле список ожидания */
    private int capacity;

    /**
     * Конструктор - создание нового объекта
     * @param capacity - список ожидания
     */
    public BoundedWaitList(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Функция получения значения поля {@link BoundedWaitList#capacity}
     * @return возвращает вместимость очереди
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Метод добавления нового элемента, проверив есть ли свободное место
     * @param element - добавляемый элемент
     */
    public void add(E element) {
        if (capacity > content.size()) {
            super.add(element);
        } else
            throw new StackOverflowError();
    }

    /**
     * Метод, возвращающий данные об объекте в строковом формате
     * @return - данные об объекте в строковом формате
     */
    public String toString() {
        return "BoundedWaitList{" +
                "capacity=" + capacity +
                ", content=" + content +
                '}';
    }
}
