package sk.stuba.fei.uim.oop;

import javax.swing.*;

public class Spusti {
    public Spusti() {
        JFrame f = new JFrame("Stvorce");
        f.setSize(300,300);
        MyCanvas canvas = new MyCanvas();
        f.add("Center",canvas);
        f.setVisible(true);
    }
}
