package rtu.klokov.practics.prac5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] response = maxAndCountMax();
        //10 20 15 4 20 20 20 3 20 4
        System.out.println(response[1]);
        System.out.println(isPalindrome("pepega"));
        System.out.println(isPalindrome("wow"));
        System.out.println(isPalindrome("new"));
        System.out.println(isPalindrome("super"));
        System.out.println(isPalindrome("newen"));
        System.out.println(isPalindrome("qooqoo"));
        System.out.println(max());
    }

    public static int[] maxAndCountMax() {
        Scanner scan = new Scanner(System.in);
        int[]response =  {scan.nextInt(), 1};
        int nextInt;

        if (response[0] != 0) {

            nextInt = scan.nextInt();
            if (nextInt == 0) {
                return response;
            } else {
                if (nextInt == response[0]) {
                    response[1]++;
                }
                response[0] = Math.max(response[0], nextInt);

                int[] nextResp = maxAndCountMax();

                if (nextResp[0] == response[0]) {
                    response[1] += nextResp[1];
                    return response;
                } else {
                    return (response[0] > nextResp[0] ? response : nextResp);
                }
            }
        } else {
            return response;
        }
    }

    private static int max() {
        Scanner scan = new Scanner(System.in);
        int next = scan.nextInt();
        if (next == 0) return 0;
        return (Math.max(next, max()));
    }

    private static boolean isPalindrome(String word) {
        if (word.length() < 2)
            return true;
        return word.charAt(0) == word.charAt(word.length() - 1) && isPalindrome(word.substring(1, word.length()-1));
    }



}