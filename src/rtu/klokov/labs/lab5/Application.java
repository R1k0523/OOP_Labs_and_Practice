package rtu.klokov.labs.lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Application extends JFrame {

private final int WINDOW_WIDTH = 500, WINDOW_HEIGHT = 500;

    Application() {
        super("Рисовалка");
        setBounds(200,200, WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new BorderLayout());
        setResizable(false);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.white);
        graphics2D.drawRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            switch (rand.nextInt(3)) {
                case 0 -> {
                    Rectangle rect = new Rectangle(WINDOW_WIDTH, WINDOW_HEIGHT);
                    graphics2D.setColor(rect.getColor());
                    Rectangle2D.Double rectangle = new Rectangle2D.Double(rect.getX(), rect.getY(), rect.getWidth(), rect.getLength());
                    graphics2D.draw(rectangle);
                    graphics2D.fill(rectangle);
                }
                case 1 -> {
                    Triangle triangle = new Triangle(WINDOW_WIDTH, WINDOW_HEIGHT);
                    graphics2D.setColor(triangle.getColor());
                    Polygon triangle1 = new Polygon(triangle.getX(), triangle.getY(), 3);
                    graphics2D.draw(triangle1);
                    graphics2D.fill(triangle1);
                }
                case 2 -> {
                    Ellipse ellipse = new Ellipse(WINDOW_WIDTH, WINDOW_HEIGHT);
                    graphics2D.setColor(ellipse.getColor());
                    Ellipse2D.Double ellipse1 = new Ellipse2D.Double(ellipse.getX(), ellipse.getY(), ellipse.getAxisA(), ellipse.getAxisB());
                    graphics2D.draw(ellipse1);
                    graphics2D.fill(ellipse1);
                }
            }
        }


    }

}
