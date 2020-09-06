package rtu.klokov.labs.lab12;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        System.out.println(checkRegexNum2("abcdefghijklmnopqrstuv18340") + "\n");
        System.out.println(checkRegexNum2("java") + "\n");
        System.out.println(checkRegexNum2("abcdefghijklmnopqrssadasdtuv18340") + "\n");
        Scanner scan = new Scanner(System.in);
        String string;
        for (int i = 0; i < 10; i++) {
            string = scan.nextLine();
            boolean booltest = checkRegexMoney(string);
            System.out.println(booltest);
        }
    }

    public static boolean checkRegexNum2(String checkString){
        String regex = "^abcdefghijklmnopqrstuv18340$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(checkString);
        return m.matches();
    }
    public static boolean checkRegexMoney(String checkString){
        String regex = "^([0-9]*)(.[0-9]*)? (USD|RUB|EUR)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(checkString);
        return m.matches();
    }

}
