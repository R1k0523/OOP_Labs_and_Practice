package rtu.klokov.practics.prac11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        AbstractChairFactory factory = new ChairFactory();
        for (int i = 0; i < 5; i++) {
            System.out.println("Choose your chair...\n1 - Victorian chair\n2 - Functional chair\n3 - Magic chair");
            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()) {
                case 1:
                    client.setChair(factory.createVictorianChair());
                    break;
                case 2:
                    client.setChair(factory.createFunctionalChair());
                    break;
                case 3:
                    client.setChair(factory.createMagicChair());
                    break;
            }
            client.sit();
            System.out.println("\n\n");
        }
    }
}
