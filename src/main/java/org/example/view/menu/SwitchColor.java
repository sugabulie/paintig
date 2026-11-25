package org.example.view.menu;

import org.example.model.Factory.ShapeState;
import org.example.model.Model;

import javax.swing.*;
import java.awt.*;


public class SwitchColor implements  AppCommand {
    private ShapeState shapeState;
    private boolean useDefault;
    private Color defaultColor;
    private JRadioButtonMenuItem radioButton;

    @Override
    public void execute() {
        radioButton.setSelected(!useDefault || defaultColor != null);
        Color color = useDefault ? defaultColor : JColorChooser.showDialog(null, "выбор цвета", Color.BLACK);
        shapeState.setColor(color != null ? color : defaultColor);
    }
}
