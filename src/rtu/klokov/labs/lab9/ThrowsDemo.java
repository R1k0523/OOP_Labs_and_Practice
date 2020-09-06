package rtu.klokov.labs.lab9;

import java.util.Scanner;

public class ThrowsDemo {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter Key ");
        int tries = 0;
        while (tries < 2) {
            try {
                String key = myScanner.nextLine();
                printDetails(key);
            } catch (Exception e) {
                tries++;
            }
        }
    }
    public void printDetails(String key) throws Exception {
        String message = getDetails(key);
        System.out.println( message );
    }

    private String getDetails(String key) throws Exception {
        if(key.equals("")) {
            throw new Exception( "Key set to empty string" );
        }
        return "data for " + key;
    }
}