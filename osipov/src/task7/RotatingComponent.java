package task7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import javax.swing.Timer;

public class RotatingComponent extends JComponent{
    Rectangle segment;
    float rotation = 0;
    Point centerOfRotation = new Point();
    
    public Point leftVertex;
    public Point rightVertex;
    
    private Timer timer;
    
    public RotatingComponent(final JComponent parent, Point centerOfRotation) {
        this.centerOfRotation = centerOfRotation;
        setBounds(parent.getBounds());
        segment = makeSegment(parent.getBounds());
        timer = new Timer(25, (ActionEvent e) -> {
            rotation = rotation < 360 ? rotation+ 0.1f : 0;
            repaint();
        });
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.clearRect(5, 5, getWidth()-60, getHeight()-30);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.pink);
        g2d.rotate(rotation, centerOfRotation.x, centerOfRotation.y);
        g2d.fillRect(segment.x, segment.y, segment.width, segment.height);
    }

    public void setCenterOfRotation(int x, int y){
        this.centerOfRotation.x = x;
        this.centerOfRotation.y = y;
    }
    
    private Rectangle makeSegment(Rectangle bounds){
        Rectangle segment = new Rectangle();
        segment.width = bounds.width/2;
        segment.height = 4;
        
        segment.x = bounds.width/4;
        segment.y = bounds.height/2;
        
        leftVertex = new Point(segment.x, segment.y);
        rightVertex = new Point(segment.x + segment.width, segment.y);
        
        return segment;
    }
}
