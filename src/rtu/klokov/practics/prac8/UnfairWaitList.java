package rtu.klokov.practics.prac8;

/**
 * Класс, наследуемый от {@link WaitList}, с взаимодействием с элементами в середине параметра {@link WaitList#content}
 * @author Клоков Сергей
 * @version 1.0
 * @param <E> - ожидающий элемент
 */
public class UnfairWaitList<E> extends WaitList {

    /**
     * Конструктор по умолчанию, вызываемый при создании нового объекта
     */
    public UnfairWaitList() {
        super();
    }

    /**
     * Метод удаления элемента из очереди
     * @param element - удаляемый элемент
     */
    public void remove(E element) {
        content.remove(element);
    }

    /**
     * Метод перемещения элемента из очереди в ее конец
     * @param element -перемещаемый элемент
     */
    public void moveToBack(E element) {
        remove(element);
        add(element);
    }
}