package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectangleButton extends JButton implements ActionListener {
    public boolean chcemStvorec;

    public RectangleButton(String label) {
        super(label);
        addActionListener(this);
        chcemStvorec=false;
    }
    public void actionPerformed(ActionEvent e){
        chcemStvorec=true;
    }
}
