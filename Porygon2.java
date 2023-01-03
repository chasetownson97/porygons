import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Random;

class Porygon2 {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            public void run() {
                EllipseComponent ellipseComponent = new EllipseComponent(525,525);
                ellipseComponent.addEllipse(175, 97, 201, 156);
                ellipseComponent.addEllipse(265, 143, 163, 56);
                ellipseComponent.addEllipse(192, 113, 52, 82);
                ellipseComponent.addEllipse(126, 308, 257, 183);
                ellipseComponent.addEllipse(51, 189, 62, 155);
                ellipseComponent.addEllipse(54, 376, 134, 94);
                ellipseComponent.addEllipse(321, 367, 122, 102);
                JOptionPane.showMessageDialog(null, ellipseComponent);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class EllipseComponent extends JComponent {

    ArrayList<Ellipse2D.Double> ellipses;
    Random random;

    EllipseComponent(int width, int height) {
        super();
        setPreferredSize(new Dimension(width,height));
        ellipses = new ArrayList<Ellipse2D.Double>();
        random = new Random();
    }

    public void addEllipse(int x, int y, int width, int height) {
        Ellipse2D.Double ellipse = new Ellipse2D.Double(
            (random.nextInt(11) * (random.nextBoolean() ? -1 : 1)) + x,
            (random.nextInt(11) * (random.nextBoolean() ? -1 : 1)) + y,
            (random.nextInt(11) * (random.nextBoolean() ? -1 : 1)) + width,
            (random.nextInt(11) * (random.nextBoolean() ? -1 : 1)) + height
            );
        ellipses.add(ellipse);
        repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(0, 0, getWidth(), getHeight());
        Dimension d = getPreferredSize();
        g2.setColor(Color.black);
        for (Ellipse2D.Double ellipse : ellipses) {
            g2.draw( new Ellipse2D.Double(
                (int)ellipse.getX(),
                (int)ellipse.getY(),
                (int)ellipse.getWidth(),
                (int)ellipse.getHeight())
                );
        }
    }
}