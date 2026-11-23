package org.example.view.menu;

import org.example.model.Factory.ShapeState;
import org.example.model.Factory.ShapeType;

import javax.swing.*;

public class SwitchShape implements AppCommand {

    private ShapeState shapeState;
    private ShapeType shapeType;
    private JRadioButtonMenuItem radioButton;
    @Override
    public void execute() {
        shapeState.setShapeType(shapeType);
        radioButton.setSelected(true);

    }
}
