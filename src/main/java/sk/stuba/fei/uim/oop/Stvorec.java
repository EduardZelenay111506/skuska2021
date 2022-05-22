package sk.stuba.fei.uim.oop;

import java.awt.*;

public class Stvorec extends Rectangle {
    Color farba;
    public Stvorec(int x,int y,int width, int height,Color c){
        super(x,y,width,height);
        farba = c;
    }

    public void kresli(Graphics g){
        g.setColor(farba);
        g.fillRect(this.x,this.y,this.width,this.height);
    }
}
