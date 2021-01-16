package rtu.klokov.practics.prac14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ExerciseFour {

    public static void main(String[] args) throws IOException {
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
        {fileName = reader.readLine();}

        String content = Files.readString(Paths.get("src/rtu/klokov/practics/prac12/" + fileName + ".txt"));
        String[] words = content.split(" ");

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    private static StringBuilder getLine(String[] words) {
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, words);
        StringBuilder sb = new StringBuilder();
        if (strings.size() == 0) {
            return new StringBuilder();
        }

        sb.append(strings.get(0));
        strings.remove(0);

        while (strings.size() > 0) {
            for (int i = 0; i < strings.size(); i++) {
                String a = strings.get(i).toLowerCase();
                String b = sb.toString().toLowerCase();
                if (a.charAt(0) == b.charAt(sb.length() - 1)) {
                    sb.append(" ").append(strings.get(i));
                    strings.remove(i);
                    continue;
                }

                if (b.charAt(0) == a.charAt(a.length() - 1)) {
                    sb.insert(0, " ");
                    sb.insert(0, strings.get(i));
                    strings.remove(i);
                }
            }
        }
        return sb;
    }
}
