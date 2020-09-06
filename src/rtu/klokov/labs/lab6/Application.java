package rtu.klokov.labs.lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Application extends JFrame {

    private final String strButton = "Let's try this";
    private final String strQuest = "I thought of a number from 1 to 20. Try to guess it. Good luck";

    private final int WINDOW_HEIGHT = 250, WINDOW_WIDTH = 380;

    private final JButton buttonGuess = new JButton(strButton);
    private final JTextField textField = new JTextField(2);
    private final JLabel labelQuest = new JLabel(strQuest);
    private final NumberGuesser numGuess = new NumberGuesser();
    Application() {
        super("NumberGuesser");
        init();
        setResizable(false);
        setBounds(200,200,WINDOW_WIDTH,WINDOW_HEIGHT);
        setLayout(new BorderLayout());
    }


    private void init() {

        labelQuest.setBounds(10, 20, 345, 60);
        textField.setBounds(WINDOW_WIDTH/2 - 20, WINDOW_HEIGHT/3, 40, 40);
        buttonGuess.setBounds(WINDOW_WIDTH/2 - 100, 160, 200, 40);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleGuess();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        buttonGuess.addActionListener(e -> handleGuess());

        add(buttonGuess);
        add(textField);
        add(labelQuest);


    }
    void handleGuess() {
        String text = textField.getText();
        try {
            boolean correct = numGuess.isCorrect(Integer.parseInt(text));
            if (correct) {

                JOptionPane.showMessageDialog(
                        null, "You guessed!","Congratulations" ,
                        JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);

            } else if (numGuess.getTries() == 0) {

                JOptionPane.showMessageDialog(
                        null, "You lost","Bye" ,
                        JOptionPane.ERROR_MESSAGE);
                setVisible(false);

            } else {

                JOptionPane.showMessageDialog(
                        null, "Wrong! The number is " +
                                (numGuess.isBigger(Integer.parseInt(text)) ? "bigger" : "smaller") +
                                " Remaining attempts: "+ numGuess.getTries(),"Carefully" ,
                        JOptionPane.WARNING_MESSAGE);

            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(
                    null, "Error in Numbers !","Alert" ,
                    JOptionPane.ERROR_MESSAGE);
        }

        textField.setText("");
    }

    private static class NumberGuesser {

        private final int number;
        private int tries;

        NumberGuesser() {
            Random rand = new Random();
            number = rand.nextInt(20)+1;
            tries = 3;
        }

        public boolean isCorrect(int guess) {

            if (guess != number) {
                tries--;
                return false;
            } else return true;
        }

        public boolean isBigger(int guess) {
            return guess < number;
        }

        public int getTries() {
            return tries;
        }
    }

}
