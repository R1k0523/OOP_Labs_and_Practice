package rtu.klokov.practics.prac13;


import java.lang.reflect.Array;

public class ArrayQueueADTTest {
    public static void fill(ArrayQueueADT queue) {
        for (int i = 1; i < 11; i++) {
            queue.enqueue(i);
        }
    }

    public static void dump(ArrayQueueADT queue) {
        while (!queue.isEmpty()) {
            System.out.println(
                    queue.size() + " " +
                            queue.element() + " " +
                            queue.dequeue()
            );
        }
    }

    public static void main() {
        ArrayQueueADT<Integer> queue = new ArrayQueueADT(new Integer[] {42, 35, 18});
        fill(queue);
        dump(queue);
        fill(queue);
        queue.clear();
        dump(queue);

    }
}
