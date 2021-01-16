package rtu.klokov.practics.prac13;


public class ArrayQueueModuleTest {
    public static void fill() {
        for (int i = 1; i < 11; i++) {
            ArrayQueueModule.enqueue(i);
        }
    }

    public static void dump() {
        while (!ArrayQueueModule.isEmpty()) {
            System.out.println(
                    ArrayQueueModule.size() + " " +
                    ArrayQueueModule.element() + " " +
                    ArrayQueueModule.dequeue()
            );
        }
    }

    public static void main() {
        ArrayQueueModule<Integer> queue = new ArrayQueueModule();
        fill();
        dump();
    }
}
