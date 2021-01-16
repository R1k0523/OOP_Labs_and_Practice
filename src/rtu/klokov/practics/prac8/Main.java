package rtu.klokov.practics.prac8;

import java.util.Random;

public class Main {

    private static String randomString(int length) {
        String response = "";
        Random rand = new Random();
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";
        for (int i = 0; i < length; i++) {
            response += alphabet.charAt(Math.abs(rand.nextInt())%26);
        }
        return response;
    }

    public static void main(String[] args) {

        WaitList<Integer> waitList = new WaitList<>();
        UnfairWaitList<String> unfairWaitList = new UnfairWaitList<>();
        BoundedWaitList <Integer> boundedWaitList = new BoundedWaitList<>(30);

        Random rand = new Random();

        for (int i = 0; i < 30; i++) {
            waitList.add(rand.nextInt(100));
            unfairWaitList.add(randomString(20));
            boundedWaitList.add(rand.nextInt(100));
        }
        try {
            boundedWaitList.add(1000);
        } catch (StackOverflowError e) {
            if (e.equals(new StackOverflowError()))
                System.out.println("Ошибка переполнения списка ожидания");
        }
        System.out.println(waitList.remove());
        System.out.println(waitList.remove());
        System.out.println(waitList.remove());
        System.out.println(unfairWaitList.remove());
        System.out.println(unfairWaitList.remove());
        System.out.println(unfairWaitList.remove());
        System.out.println(boundedWaitList.remove());
        System.out.println(boundedWaitList.remove());
        System.out.println(boundedWaitList.remove());
        for (int i = 0; i < 27; i++) {
            waitList.remove();
            unfairWaitList.remove();
            boundedWaitList.remove();
        }
        waitList.add(100000);
        unfairWaitList.add("test");
        boundedWaitList.add(42);

        System.out.println(waitList.remove());
        System.out.println(unfairWaitList.remove());
        System.out.println(boundedWaitList.remove());
        waitList.add(100000);
        unfairWaitList.add("test");
        boundedWaitList.add(42);

        System.out.println(waitList.contains(100000));
        System.out.println(unfairWaitList.contains("testing"));
        System.out.println(boundedWaitList.contains(100000));
        System.out.println(waitList.contains(42));
        System.out.println(unfairWaitList.contains("test"));
        System.out.println(boundedWaitList.contains(42));
        System.out.println(boundedWaitList.getCapacity());

        unfairWaitList.add("test2");
        unfairWaitList.add("test3");
        unfairWaitList.add("test4");

        System.out.println(unfairWaitList.content.peek());
        unfairWaitList.moveToBack("test");
        unfairWaitList.remove();
        unfairWaitList.remove();
        unfairWaitList.remove("test4");
        System.out.println(unfairWaitList.remove());


    }

}
