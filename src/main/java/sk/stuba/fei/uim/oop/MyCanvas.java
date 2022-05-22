package sk.stuba.fei.uim.oop;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;

public class MyCanvas extends Canvas implements MouseListener {
    public RectangleButton gombik;
    public HashSet<Rectangle> nasestvorce = new HashSet<Rectangle>();



    public MyCanvas(RectangleButton gombik) {
        super();
        addMouseListener(this);
        this.gombik=gombik;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        if(gombik.chcemStvorec){
            nasestvorce.add(new Rectangle(x,y,20,20));
            repaint();
            gombik.chcemStvorec=false;
        }
    }

    public void paint(Graphics g){
        for (Rectangle aktualny : nasestvorce){
            g.drawRect(aktualny.x,aktualny.y, aktualny.width,aktualny.height);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
