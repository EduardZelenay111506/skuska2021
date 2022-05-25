package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Play {
    public static final String DRAWING = "KRESLENIE";
    public static final String MOVING = "PRESUVANIE";
    public static final String COLOR = "FARBA";

    public Play() {
        JFrame frame = new JFrame("Skuska");
        frame.setSize(900,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());

        JPanel sideMenu = new JPanel();
        Logic logic = new Logic(sideMenu);
        frame.add(logic.getCanvas(), BorderLayout.CENTER);

        JButton first = new JButton(DRAWING);
        first.addActionListener(logic);
        JButton second = new JButton(MOVING);
        second.addActionListener(logic);
        JButton third = new JButton(COLOR);
        third.addActionListener(logic);

        sideMenu.setLayout(new GridLayout(1, 4));
        sideMenu.add(first);
        sideMenu.add(second);
        sideMenu.add(third);
        sideMenu.add(logic.getLabel());

        frame.add(sideMenu, BorderLayout.PAGE_END);
        frame.setVisible(true);
    }
}
