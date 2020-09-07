package rtu.klokov.practics.prac7;

import java.util.Queue;

public class GameCalculator {

    public static String calculate(Queue<Integer> cards1, Queue<Integer> cards2) {

        int firstCard, secondCard;
        for (int i = 0; i < 106; i++) {
            firstCard = cards1.remove();
            secondCard = cards2.remove();
            if ((secondCard == 9 && firstCard == 0) || ((firstCard > secondCard) && !(secondCard == 0 && firstCard == 9))) {
                cards1.add(firstCard);
                cards1.add(secondCard);
            } else if ((secondCard == 0 && firstCard == 9) ^ ((firstCard < secondCard))) {
                cards2.add(firstCard);
                cards2.add(secondCard);
            }

            if (cards1.isEmpty()) {
                return ("Second player won. Turnes: " + (i+1));
            } else if (cards2.isEmpty()) {
                return ("First player won. Turnes: " + (i+1));
            }
        }
        return "Botva!";
    }
}

