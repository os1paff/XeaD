package task8;



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.Timer;

public class GradientComponent extends JComponent{

String name;
Color color;
Color defaultColor;
JComponent parent;
//---вспомогательные переменные---
private Timer timer;
//Пригодятся временные переменные цвета
private float R;
private float G;
private float B;
//шаг, необходимый каждому цвету для достижения серого
private float deltaR; 
private float deltaG;
private float deltaB;

public GradientComponent(Color compColor, final JComponent parent) {
    this.color = compColor;
    defaultColor = compColor;
    this.parent = parent;
    R = compColor.getRed();
    G = compColor.getGreen();
    B = compColor.getBlue();
    
    setBounds(parent.getBounds());
    
    /*
     * шаг вычисляется как:
     * (Начальный цвет - Серый цвет)/Время(мс)
     * p.s. Для шагов, расписаных на каждую миллисекунду, в течение 5 секунд, время было бы 5000,
     * но так как для каждого цвета создаётся новый объект, то для снижения нагрузки, 
     * было принято решение рассчитывать шаги хотя бы в 10мс интервале
     * */
    deltaR = -(compColor.getRed() - 199)/100f; 
    deltaG = -(compColor.getGreen() - 199)/100f;
    deltaB = -(compColor.getBlue() - 199)/100f;
    timer = new Timer(10, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            //(теоретически, новые объекты можно было бы организовать в пул, но я решил не усложнять алгоритм)
            //вычисление нового цвета
            R = Math.abs(R+deltaR);
            G = Math.abs(G+deltaG);
            B = Math.abs(B+deltaB);
            //плодить новые объекты - плохая мысль, но awt.Color не поддерживает настройку..
            color = new Color((int)R, (int)G, (int)B);
            //если достигнут серый цвет, дельта меняет знак, и начинается перекрашивание обратно
            if(isGray()) {
                deltaR = -deltaR;
                deltaG = -deltaG;
                deltaB = -deltaB;
            }
            //если достигнут дефолт, перекрашивание идёт в обратную сторону
            if(isDefault()) {
                deltaR = -deltaR;
                deltaG = -deltaG;
                deltaB = -deltaB;
            }
            repaint();
        }
    });
    changeColor();
}

@Override
protected void paintComponent(Graphics g) {
    g.clearRect(5, 5, getWidth()-30, getHeight()-30);
    Graphics2D g2d = (Graphics2D)g;
    g2d.rotate(Math.toRadians(35));
    g.setColor(color);
    g.fillRect(30, 15, getWidth()-5, 3);
}

private boolean isGray() {
    //из-за особенностей хранения float в памяти, обычные проверки тут не подходят
    boolean redEqual = Math.abs(R - 199)<0.1f;
    boolean greenEqual = Math.abs(G - 199)<0.1f;
    boolean blueEqual = Math.abs(B - 199)<0.1f;
    return redEqual&&greenEqual&&blueEqual;
}

private boolean isDefault() {
    boolean redEqual = Math.abs(R - defaultColor.getRed())<0.1f;
    boolean greenEqual = Math.abs(G - defaultColor.getGreen())<0.1f;
    boolean blueEqual = Math.abs(B - defaultColor.getBlue())<0.1f;
    return redEqual&&greenEqual&&blueEqual;
} 

public void changeColor() {
    //блокировка повторных запусков, пока не истекут 5 секунд
    if(!timer.isRunning()) {
        timer.start();
    }
}
}
