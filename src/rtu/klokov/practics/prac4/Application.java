package rtu.klokov.practics.prac4;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    private final String strMilan = "AC Milan",
            strMadrid = "Real Madrid",
            strResult = "Result: ",
            strScorer = "Last Scorer: ",
            strWinner = "Winner: ";
    private String []winnerType = {"Draw", strMilan, strMadrid};

    private final int WINDOW_HEIGHT = 250, WINDOW_WIDTH = 380, MARGIN = 20;


    private JButton buttonMilan = new JButton(strMilan);
    private JButton buttonMadrid = new JButton(strMadrid);
    private JLabel jlabelResult = new JLabel(strResult + "0 X 0");
    private JLabel jlabelScorer = new JLabel(strScorer + "N/A");
    private Label labelWinner = new Label(strWinner + winnerType[0]);
    GoalHandler gHandler = new GoalHandler();

    Application() {
        super("Score handler for football match");

        init();

        this.setBounds(200,200,WINDOW_WIDTH,WINDOW_HEIGHT);
        setLayout(new BorderLayout());
    }


    private void init() {

        jlabelResult.setBounds(MARGIN, MARGIN, WINDOW_WIDTH - MARGIN, 30);
        jlabelScorer.setBounds(MARGIN,2*MARGIN + 20, WINDOW_WIDTH - MARGIN, 30);
        labelWinner.setBounds(MARGIN, 3*MARGIN + 40, WINDOW_WIDTH - MARGIN, 40);
        buttonMilan.setBounds(MARGIN, 4*MARGIN + 60, 150, 60);
        buttonMadrid.setBounds(2*MARGIN + 150, 4*MARGIN + 60, 150, 60);

        buttonMilan.addActionListener(e -> {
            gHandler.goalByMilan();
            refresh();
        });

        buttonMadrid.addActionListener(e -> {
            gHandler.goalByMadrid();
            refresh();
        });

        add(buttonMilan);
        add(buttonMadrid);
        add(jlabelResult);
        add(jlabelScorer);
        add(labelWinner);


    }

    private void refresh() {
        jlabelScorer.setText(strScorer + gHandler.getLastScorer());
        jlabelResult.setText(strResult + gHandler.getResult());
        labelWinner.setText(strWinner + gHandler.getWinner());
    }

    private class GoalHandler {
        private int goalsMilan;
        private int goalsMadrid;
        private String lastScorer;

        public GoalHandler(int goalsMilan, int goalsMadrid) {
            this.goalsMilan = goalsMilan;
            this.goalsMadrid = goalsMadrid;
        }

        public GoalHandler() {
            goalsMadrid = 0;
            goalsMilan = 0;
        }

        public void goalByMilan() {
            goalsMilan++;
            lastScorer = strMilan;
        }
        public void goalByMadrid() {
            goalsMadrid++;
            lastScorer = strMadrid;
        }

        public String getResult() {
            return (goalsMilan + " X " + goalsMadrid);
        }

        public String getLastScorer() {
            return (lastScorer);
        }

        public String getWinner() {
            if (goalsMilan == goalsMadrid) {
                return "DRAW";
            } else {
                return (goalsMilan > goalsMadrid ? strMilan : strMadrid);
            }
        }
    }

}
