package sk.stuba.fei.uim.oop;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashSet;

public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener {
    public ArrayList<Stvorec> nasestvorce = new ArrayList<Stvorec>();

    Stvorec aktualnyStvorec;

    int xpos,ypos;

    public MyCanvas() {
        super();
        this.xpos=0;
        this.ypos=0;
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void paint(Graphics g){
        for (Stvorec aktualny : nasestvorce){
            aktualny.kresli(g);
        }
        if (aktualnyStvorec!=null){
            aktualnyStvorec.kresli(g);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xpos=e.getX();
        ypos=e.getY();
        aktualnyStvorec=new Stvorec(xpos,ypos,1,1,Color.blue);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        nasestvorce.add(aktualnyStvorec);
        repaint();
        aktualnyStvorec = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX();
        int dy = e.getY();
        if (aktualnyStvorec!=null){
            if(dx > xpos && dy > ypos) {
                aktualnyStvorec.width = dx - xpos;
                aktualnyStvorec.height = dy - ypos;
            }
            if(dx < xpos && dy > ypos) {
                aktualnyStvorec.x=dx;
                aktualnyStvorec.width = xpos - dx;
                aktualnyStvorec.height = dy - ypos;
            }
            if(dx > xpos && dy < ypos) {
                aktualnyStvorec.y=dy;
                aktualnyStvorec.width = dx - xpos;
                aktualnyStvorec.height = ypos - dy;
            }
            if(dx < xpos && dy < ypos) {
                aktualnyStvorec.x=dx;
                aktualnyStvorec.y=dy;
                aktualnyStvorec.width = xpos - dx;
                aktualnyStvorec.height = ypos - dy;
            }
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
