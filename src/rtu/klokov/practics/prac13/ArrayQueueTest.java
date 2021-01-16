package rtu.klokov.practics.prac13;


public class ArrayQueueTest {
    public static void fill(ArrayQueue stack) {
        for (int i = 1; i < 11; i++) {
            stack.enqueue(i);
        }
    }

    public static void dump(ArrayQueue stack) {
        while (!stack.isEmpty()) {
            System.out.println(
                    stack.size() + " " +
                            stack.element() + " " +
                            stack.dequeue()
            );
        }
    }

    public static void main() {
        ArrayQueue<Integer> stack = new ArrayQueue();
        fill(stack);
        dump(stack);
    }
}
