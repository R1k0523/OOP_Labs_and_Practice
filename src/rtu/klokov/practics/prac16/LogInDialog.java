package rtu.klokov.practics.prac16;

import javax.swing.*;
import java.awt.event.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LogInDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField ageField;
    private JTextField numberField;
    private JTextField cityField;
    private JTextField indexField;
    private JTextField streetField;
    private JTextField corpusField;
    private Customer customer;

    public LogInDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        pack();
        setVisible(true);
    }

    private void onOK() {
        String name = getLine(nameField, false);

        String surName = getLine(surnameField, false);

        int age = getInt(ageField, 200, false);

        String city = getLine(cityField, false);

        int zipCode = getInt(indexField, 1000000, false);

        String street = getLine(streetField, false);

        char buildingLetter = getLine(corpusField, true).charAt(0);

        int apartment = getInt(numberField, 10000, true);

        if (!(name == "-1" || surName == "-1" || age == -1 || city == "-1" ||
                zipCode == -1 || street == "-1" || buildingLetter == '-' || apartment == -1)) {
            customer = new Customer(name, surName, age, new Address(city, zipCode, street, buildingLetter, apartment));
            dispose();
        }

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public Customer getCustomer() {
        return customer;
    }

    private int getInt(JTextField field, int to, boolean canBeZero) {
            try {
                int res = Integer.parseInt(field.getText());
                if ((res > 0 && res < to) || (canBeZero && res == 0))
                    return res;
            } catch (Exception e) {
                field.setText("");
            }
            return -1;
    }

    private String getLine(JTextField field, boolean empty) {
            try {
                String res = field.getText();
                if (empty || !res.isEmpty())
                    return res;
            } catch (Exception e) {
                field.setText("");
            }
            return "-1";
    }


}
