package rtu.klokov.labs.lab11;

import com.sun.jdi.event.ExceptionEvent;

import java.io.EOFException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Main {

    public static void main(String[] args)  {

       Filelist("C:\\");

    }


    public static void Filelist(String path) {
        File f = new File(path);
        String[] fArray = null;
        if (f.exists()||f.isDirectory())
            fArray = f.list();
        else
            System.out.print("Папка не найдена");
        ArrayList<String> list = new ArrayList(Arrays.asList(fArray));

        for (int i =0; i<5;i++) {
                System.out.println(list.get(i));
        }
    }
}
