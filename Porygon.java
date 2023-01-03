import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Line2D;

import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import java.util.ArrayList;
import java.util.Random;

class Porygon {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            public void run() {
                LineComponent lineComponent = new LineComponent(525,525);
                //head
                lineComponent.addLine(198, 80, 253, 88);
                lineComponent.addLine(198, 80, 140, 116);
                lineComponent.addLine(140, 116, 78, 216);
                lineComponent.addLine(78, 216, 60, 296);
                lineComponent.addLine(60, 296, 104, 312);
                lineComponent.addLine(104, 312, 222, 265);
                lineComponent.addLine(222, 265, 286, 201);
                lineComponent.addLine(286, 201, 298, 142);
                lineComponent.addLine(298, 142, 253, 88);
                lineComponent.addLine(253, 88, 227, 136);
                lineComponent.addLine(227, 136, 140, 116);
                lineComponent.addLine(227, 136, 189, 146);
                lineComponent.addLine(189, 146, 179, 192);
                lineComponent.addLine(179, 192, 197, 213);
                lineComponent.addLine(197, 213, 242, 205);
                lineComponent.addLine(242, 205, 253, 162);
                lineComponent.addLine(253, 162, 227, 136);
                lineComponent.addLine(253, 162, 298, 142);
                lineComponent.addLine(179, 192, 100, 310);
                lineComponent.addLine(197, 213, 104, 312);
                lineComponent.addLine(177, 283, 164, 247);
                lineComponent.addLine(164, 247, 148, 236);
                lineComponent.addLine(148, 236, 78, 216);
                //tail
                lineComponent.addLine(343, 211, 392, 49);
                lineComponent.addLine(392, 49, 404, 50);
                lineComponent.addLine(404, 50, 412, 66);
                lineComponent.addLine(412, 66, 398, 255);
                lineComponent.addLine(398, 255, 393, 259);
                lineComponent.addLine(371, 223, 404, 50);
                //body
                lineComponent.addLine(270, 220, 358, 212);
                lineComponent.addLine(358, 212, 389, 241);
                lineComponent.addLine(389, 241, 394, 275);
                lineComponent.addLine(400, 273, 464, 299);
                lineComponent.addLine(464, 299, 461, 338);
                lineComponent.addLine(461, 338, 398, 475);
                lineComponent.addLine(398, 475, 331, 450);
                lineComponent.addLine(331, 450, 321, 436);
                lineComponent.addLine(321, 436, 347, 291);
                lineComponent.addLine(328, 391, 308, 419);
                lineComponent.addLine(308, 419, 251, 401);
                lineComponent.addLine(251, 401, 160, 347);
                lineComponent.addLine(201, 372, 187, 391);
                lineComponent.addLine(187, 391, 134, 367);
                lineComponent.addLine(134, 367, 143, 297);
                lineComponent.addLine(181, 282, 160, 347);
                lineComponent.addLine(160, 347, 284, 369);
                lineComponent.addLine(284, 369, 308, 419);
                lineComponent.addLine(181, 360, 175, 386);
                lineComponent.addLine(284, 369, 257, 240);
                lineComponent.addLine(284, 369, 301, 293);
                lineComponent.addLine(301, 293, 257, 240);
                lineComponent.addLine(257, 240, 251, 237);
                lineComponent.addLine(257, 240, 345, 214);
                lineComponent.addLine(284, 369, 389, 241);
                lineComponent.addLine(398, 475, 388, 457);
                lineComponent.addLine(388, 457, 321, 436);
                lineComponent.addLine(388, 457, 422, 329);
                lineComponent.addLine(422, 329, 347, 291);
                lineComponent.addLine(347, 291, 400, 273);
                lineComponent.addLine(422, 329, 464, 299);
                JOptionPane.showMessageDialog(null, lineComponent);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}

class LineComponent extends JComponent {

    ArrayList<Line2D.Double> lines;
    Random random;

    LineComponent(int width, int height) {
        super();
        setPreferredSize(new Dimension(width,height));
        lines = new ArrayList<Line2D.Double>();
        random = new Random();
    }

    public void addLine(int x1, int y1, int x2, int y2) {
        Line2D.Double line = new Line2D.Double(
            (random.nextInt(11) * (random.nextBoolean() ? -1 : 1)) + x1,
            (random.nextInt(11) * (random.nextBoolean() ? -1 : 1)) + y1,
            (random.nextInt(11) * (random.nextBoolean() ? -1 : 1)) + x2,
            (random.nextInt(11) * (random.nextBoolean() ? -1 : 1)) + y2
            );
        lines.add(line);
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        Dimension d = getPreferredSize();
        g.setColor(Color.black);
        for (Line2D.Double line : lines) {
            g.drawLine(
                (int)line.getX1(),
                (int)line.getY1(),
                (int)line.getX2(),
                (int)line.getY2()
                );
        }
    }
}