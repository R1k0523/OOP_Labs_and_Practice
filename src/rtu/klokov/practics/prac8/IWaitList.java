package rtu.klokov.practics.prac8;
/**
 * Интерфейс для списка ожидания
 * @author Клоков Сергей
 * @version 1.0
 * @param <E> - ожидающий элемент
 */
import java.util.Collection;

public interface IWaitList<E> {
    /**
     * Метод добавления нового элемента
     * @param element - добавляемый элемент
     */
    void add(E element);
    /**
     * Метод извлечения первого элемента в очереди
     * @return возвращает удаленный элемент
     */
    E remove();
    /**
     * Метод проверки, есть ли элемент в очереди
     * @param element - проверяемый элемент
     * @return true - если элемент присутствует, false - отсутствует
     */
    boolean contains (E element);
    /**
     * Метод проверки, есть ли элемент в очереди
     * @param c - коллекция проверяемых элементов
     * @return true - если элемент присутствует, false - отсутствует
     */
    boolean containsAll (Collection<E> c);
    /**
     * Проверка, пустая ли очередь
     * @return true - если элемент присутствует, false - отсутствует
     */
    boolean isEmpty();

}
