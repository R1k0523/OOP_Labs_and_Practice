package rtu.klokov.practics.prac9;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LabClassUI extends JFrame implements MouseListener{
    JTable table = new JTable(40, 3);
    JScrollPane scrollPane =new JScrollPane(table);
    JButton buttonSort =new JButton("Отсортировать");
    JButton buttonAdd =new JButton("Добавить");
    JButton buttonFind =new JButton("Найти");
    JTextField idField=new JTextField(2);
    JTextField nameField=new JTextField(6);
    JTextField gpaField=new JTextField(2);
    JLabel idLabel= new JLabel("№ студента");
    JLabel nameLabel= new JLabel("ФИО");
    JLabel gpaLabel=new JLabel("Средний балл");
    JPanel textPanel=new JPanel();
    JPanel buttonsPanel =new JPanel();
    DatabaseDriver dbDriver =new DatabaseDriver();

    private void fillWindow(){
        Object[] columns = {"№ студента","ФИО", "Средний балл"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.setRowHeight(40);
        table.setIntercellSpacing(new Dimension(10, 10));
        table.setGridColor(Color.gray);
        table.setEnabled(false);
        table.getTableHeader().setReorderingAllowed(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(Box.createHorizontalGlue());
        textPanel.add(idLabel);
        textPanel.add(idField);
        textPanel.add(nameLabel);
        textPanel.add(nameField);
        textPanel.add(gpaLabel);
        textPanel.add(gpaField);
        setBackground(Color.gray);
        textPanel.setBackground(Color.lightGray);
        textPanel.add(Box.createVerticalStrut(10));
        buttonsPanel.add(buttonAdd);
        buttonsPanel.add(buttonFind);
        buttonsPanel.add(buttonSort);
        textPanel.add(buttonsPanel);
        buttonsPanel.setBackground(Color.lightGray);
        setLayout(new GridBagLayout());
        GridBagConstraints textFieldsConstraint= new GridBagConstraints();
        textFieldsConstraint.fill=GridBagConstraints.HORIZONTAL;
        textFieldsConstraint.anchor=GridBagConstraints.NORTHWEST;
        textFieldsConstraint.weightx=0.2f;
        textFieldsConstraint.weighty=0.6f;
        textFieldsConstraint.gridx=1;

        GridBagConstraints scrollConstraint=new GridBagConstraints();
        scrollConstraint.fill=GridBagConstraints.HORIZONTAL;
        scrollConstraint.anchor=GridBagConstraints.WEST;
        scrollConstraint.weightx=1.0f;
        scrollConstraint.weighty=0.6f;
        scrollConstraint.gridx=0;
        add(scrollPane,scrollConstraint);
        add(textPanel,textFieldsConstraint,1);
    }

    public void setClickers(){
       buttonAdd.addMouseListener(this);
        buttonFind.addMouseListener(this);
        buttonSort.addMouseListener(this);

    }

    LabClassUI(){
        JFrame.setDefaultLookAndFeelDecorated(false);
        JDialog.setDefaultLookAndFeelDecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 460);

        fillWindow();
        setClickers();
        setVisible(true);
    }


    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (buttonFind.equals(source)) {
            try {
                JOptionPane.showMessageDialog(null, "Студент: " + dbDriver.find(nameField.getText()));
            } catch (StudentNotFoundException studentNotFoundException) {
            }
            nameField.setText("");
        } else if (buttonSort.equals(source)) {
            dbDriver.sort();
            table.setModel(dbDriver.getTable());
        } else if (buttonAdd.equals(source)) {
            try {
                dbDriver.addStudent(nameField.getText(), idField.getText(), gpaField.getText());
            } catch (EmptyStringException EE) {
            } catch (NumberFormatException E) {
                JOptionPane.showMessageDialog(null, "Ввод некорректен", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }

            table.setModel(dbDriver.getTable());
            idField.setText("");
            nameField.setText("");
            gpaField.setText("");
        }
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
}
