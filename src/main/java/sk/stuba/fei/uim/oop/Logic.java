package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Logic extends MyAdapter{
    @Getter
    private MyCanvas canvas;
    private JPanel menu;
    private MyColor blue;
    private MyColor red;
    private MyColor green;
    private MyColor thisColor;
    @Getter
    private JLabel label;
    private boolean drawing;
    private boolean moving;


    public Logic(JPanel sidemenu) {
        this.menu=sidemenu;
        this.canvas=new MyCanvas();
        this.canvas.addMouseListener(this);
        this.canvas.addMouseMotionListener(this);
        initializeColors();
        this.label = new JLabel();
        this.label.setHorizontalAlignment(SwingConstants.CENTER);
        this.label.setVerticalAlignment(SwingConstants.CENTER);
        this.drawing=true;
        this.moving=false;
        this.updateLabel();
    }
    private void initializeColors(){
        this.blue=new MyColor(Color.BLUE);
        this.red=new MyColor(Color.RED);
        this.green=new MyColor(Color.GREEN);
        this.blue.setNext(red);
        this.red.setNext(green);
        this.green.setNext(blue);
        this.thisColor=this.red;
    }

    private void updateLabel(){
        if (this.drawing){
            this.label.setText("DRAWING");
        }
        if (this.moving){
            this.label.setText("MOVING");
        }
        this.menu.setBackground(this.thisColor.getColor());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Play.COLOR)){
            this.changeColor();
        }
        if (e.getActionCommand().equals(Play.DRAWING)){
            this.drawing=true;
            this.moving=false;
        }
        if(e.getActionCommand().equals(Play.MOVING)){
            this.drawing=false;
            this.moving=true;
        }
            this.updateLabel();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (this.drawing){
            this.canvas.startDraw(e,this.thisColor.getColor());
        }
        if (this.moving){
            this.canvas.startDrag(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.drawing){
            this.canvas.draw(e);
        }
        if (this.moving){
            this.canvas.drag(e);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.drawing || this.moving) {
            this.canvas.end(e);
        }
    }


    private void changeColor(){
        this.thisColor=this.thisColor.getNext();
    }
}
