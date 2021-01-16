package rtu.klokov.practics.prac9;

import javax.swing.*;

public class EmptyStringException extends Exception {
    EmptyStringException(String message){
        JOptionPane.showMessageDialog(null,
                "Поле "+message+" пусто",
                "Ошибка",
                JOptionPane.ERROR_MESSAGE);
    }
}
