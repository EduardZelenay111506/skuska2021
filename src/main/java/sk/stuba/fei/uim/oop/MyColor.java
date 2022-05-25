package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class MyColor {
    @Getter
    private Color color;
    @Getter
    @Setter
    private MyColor next;

    public MyColor(Color color) {
        this.color = color;
    }
}
