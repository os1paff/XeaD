package task8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.Timer;

public class RotatingComponent extends JComponent{
    Polygon triangle;
    float rotation = 0;
    Point weightCenter = new Point();
    Timer timer;
    
    public RotatingComponent(final JComponent parent) {
        setBounds(parent.getBounds());
        triangle = makeTriangle(parent.getBounds());
        timer = new Timer(25, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotation = rotation < 360 ? rotation+ 0.1f : 0; 
                repaint();
            }
        });
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.clearRect(5, 5, getWidth()-30, getHeight()-30);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.pink);
        g2d.rotate(rotation, weightCenter.x, weightCenter.y);
        g2d.fillPolygon(triangle);
    }

    private Polygon makeTriangle(Rectangle bounds){
        Polygon triangle = new Polygon();
        triangle.addPoint(20, (int) (bounds.getHeight()/2));
        triangle.addPoint((int) (bounds.getWidth()/2)-10, 20);
        triangle.addPoint((int) (bounds.getWidth()-40), (int) (bounds.getHeight()/2));
        
        weightCenter.x = (int) (20 + (bounds.getWidth()/2)-10 + bounds.getWidth()-40)/3;
        weightCenter.y = (int) ((bounds.getHeight()/2) + 20 + bounds.getHeight()/2)/3;
        return triangle;
    }
}
