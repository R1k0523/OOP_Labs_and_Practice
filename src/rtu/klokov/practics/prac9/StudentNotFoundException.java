package rtu.klokov.practics.prac9;

import javax.swing.*;

public class StudentNotFoundException extends Exception {
   StudentNotFoundException(String message){
        JOptionPane.showMessageDialog(null,
                "Студент " + message +" не найден",
                "Ошибка",
                JOptionPane.ERROR_MESSAGE);
    }
}
