package rtu.klokov.labs.lab13;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args)  {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println(passwordCheck(scan.nextLine()) + "\n");
        }

    }

    public static boolean passwordCheck(String pass) {
        String regex = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d_]{8,}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pass);
        return m.matches();
    }
}
