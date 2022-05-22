package sk.stuba.fei.uim.oop;

import javax.swing.*;

public class Spusti {
    public Spusti() {
        JFrame f = new JFrame("Stvorce");
        JPanel p = new JPanel();
        RectangleButton b = new RectangleButton("Chcem Stvorec");
        p.add(b);
        f.add("North",p);

        f.setSize(300,300);
        MyCanvas canvas = new MyCanvas(b);
        f.add("Center",canvas);
        f.setVisible(true);
    }
}
