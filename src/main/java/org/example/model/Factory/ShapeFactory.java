package org.example.model.Factory;

import org.example.model.MyShape;
import org.example.model.fill.FillBehavior;
import org.example.model.fill.NoFill;

import java.awt.*;

public class ShapeFactory {
    public MyShape createShape(ShapeType shapeType, Color color){
        FillBehavior fillBehavior=new NoFill();
        return shapeType.createShape(fillBehavior, color);
    }
}
