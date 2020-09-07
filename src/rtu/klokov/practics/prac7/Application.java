package rtu.klokov.practics.prac7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class Application extends  JFrame {
    private static final String path = "src/rtu/klokov/practics/prac7/resources/";
    private static final String picEmpty = path + "emptySpace.png";
    private static String currentCard = "";
    private static boolean dragged = false;


    private final Vector<ImageIcon> imageIcons = new Vector<>();
    private final Vector<JLabel> imageLabels = new Vector<>();
    private final Vector<JLabel> emptyImageLabels = new Vector<>();
    private static final DragMouseAdapter listener = new DragMouseAdapter();
    private static final JLabel labelHand = new JLabel(new ImageIcon(path + "hand.png"));

    private final JLabel labelFirst = new JLabel("First player");

    private final JLabel labelSecond = new JLabel("Second player");
    Application() {
        super("Drunk Man");
        this.getContentPane().setBackground( Color.getHSBColor(242, 203, 7) );
        init();
    }

    private void addResources() {
        for (int i = 0; i < 10; i++) {
            imageIcons.add(new ImageIcon("src/rtu/klokov/practics/prac7/resources/" + i + ".png"));
        }
    }
    private void addLabels() {

        labelHand.setMinimumSize(new Dimension(80, 120));
        labelHand.setMaximumSize(new Dimension(80, 120));
        labelFirst.setFont (labelFirst.getFont ().deriveFont (30.0f));
        labelSecond.setFont(labelFirst.getFont());
        for (int i = 0; i < 10; i++) {
            var label = new JLabel(imageIcons.get(i), JLabel.CENTER);
            var label1 = new JLabel(new ImageIcon(picEmpty));

            label.addMouseListener(listener);
            label1.addMouseListener(listener);

            label.setMinimumSize(new Dimension(100, 150));
            label1.setMinimumSize(new Dimension(100, 150));
            label.setMaximumSize(new Dimension(100, 150));
            label1.setMaximumSize(new Dimension(100, 150));

            emptyImageLabels.add(label);
            imageLabels.add(label1);
        }
    }
    private void init() {
        addResources();
        addLabels();
        var buttonCalculate = new JButton();
        buttonCalculate.setFocusable(false);
        buttonCalculate.setTransferHandler(new TransferHandler("icon"));
        buttonCalculate.setMinimumSize(new Dimension(90, 90));
        buttonCalculate.setText("Let's play");
        buttonCalculate.addActionListener(e -> {
            if (isAllUsed()) {
                simulateGame();
            } else {
                showWarning();
            }
        });

        ArrayList<JComponent> components = new ArrayList<>();
        components.add(labelFirst); // 0
        components.add(labelSecond); // 1
        components.addAll(imageLabels); // 2 - 11
        components.addAll(emptyImageLabels); // 12 - 21
        components.add(labelHand); // 22
        components.add(buttonCalculate); // 23
        JComponent[] componentsArray = new JComponent[24];
        components.toArray(componentsArray);
        createLayout(componentsArray);

        setTitle("Drunk Man");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void showWarning() {
        JOptionPane.showMessageDialog(
                null, "Not all cards used","Warning" ,
                JOptionPane.WARNING_MESSAGE);
    }

    private void simulateGame() {
        Queue<Integer> first = new LinkedList<>();
        Queue<Integer> second = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
          first.add(getCard(i));
          second.add(getCard(i+5));
        }
        System.out.println(first.toString());
        String result = GameCalculator.calculate(first, second);
        JOptionPane.showMessageDialog(
                null, result,"Game calculated" ,
                JOptionPane.INFORMATION_MESSAGE);
    }

    private int getCard(int cardIndex) {
        int k = 0;
        String src = imageLabels.get(cardIndex).getIcon().toString();
        return (src.charAt(40) - '0');
    }

    private boolean isAllUsed() {
        for (int i = 0; i < 10; i++) {
            if (imageLabels.get(i).getIcon().toString().equals(picEmpty))
                return false;
        }
        return true;
    }

    private static class DragMouseAdapter extends MouseAdapter {


        public void mouseClicked(MouseEvent e) {
            var c = (JLabel) e.getSource();
            if (!c.getIcon().toString().equals(picEmpty)) { //Если данная ячейка занята
                    if (dragged) {
                        String temp = currentCard;
                        currentCard = c.getIcon().toString();
                        c.setIcon(new ImageIcon(temp));
                    } else {
                        currentCard = c.getIcon().toString();
                        c.setIcon(new ImageIcon(picEmpty));
                    }
                dragged = true;
                labelHand.setIcon(new ImageIcon(new ImageIcon(currentCard)
                        .getImage().getScaledInstance(80, 120, Image.SCALE_DEFAULT)));
            } else
                if (dragged) {
                    c.setIcon(new ImageIcon(currentCard));
                    currentCard = picEmpty;
                    dragged = false;
                    labelHand.setIcon(new ImageIcon(path + "hand.png"));
                }
        }
    }



    private void createLayout(JComponent... components) {

        var pane = getContentPane();
        var gl = new GroupLayout(pane);
        GroupLayout.Group[] groups = new GroupLayout.Group[4];

        pane.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        groups[0] = gl.createSequentialGroup();
        groups[1] = gl.createSequentialGroup();
        groups[2] = gl.createSequentialGroup();
        groups[3] = gl.createSequentialGroup();

        addGroups(groups, components);

        gl.setHorizontalGroup(gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(groups[0])
                .addGroup(groups[1])
                .addGroup(groups[2])
                .addGroup(groups[3])
        );

        groups[0] = gl.createParallelGroup();
        groups[1] = gl.createParallelGroup();
        groups[2] = gl.createParallelGroup();
        groups[3] = gl.createParallelGroup();

        addGroups(groups, components);

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(groups[0])
                .addGap(30)
                .addGroup(groups[1])
                .addGap(60)
                .addGroup(groups[2])
                .addGap(30)
                .addGroup(groups[3])
        );

        pack();
    }

    private void addGroups(GroupLayout.Group[] groups, JComponent[] components) {
        groups[0].addComponent(components[0]);
        groups[1].addComponent(components[1]);
        groups[2].addComponent(components[22]);
        groups[3].addComponent(components[23]);
        for (int i = 2; i < 7; i++) {
            groups[0].addComponent(components[i])
                    .addGap(30);
            groups[1].addComponent(components[i+5])
                    .addGap(30);
            groups[2].addComponent(components[i+10])
                    .addGap(30);
            groups[3].addComponent(components[i+15])
                    .addGap(30);
        }
    }


}
