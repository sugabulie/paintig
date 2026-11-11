package org.example.model.Factory;

import org.example.model.MyShape;
import org.example.model.fill.Fill;
import org.example.model.fill.FillBehavior;
import org.example.model.fill.NoFill;

import java.awt.*;


public class ShapeFactory {
    private static ShapeFactory instance;
    private ShapeState defaultShape;

    private ShapeFactory() {
//        defaultShape=new ShapeState(ShapeState)

    }

    public static ShapeFactory getInstance() {
        synchronized (ShapeFactory.class) {
            if (instance == null) {
                instance = new ShapeFactory();
            }
            return instance;
        }
    }

    public MyShape createShape(ShapeType shapeType, Color color, boolean isFill) {
        FillBehavior fillBehavior = isFill ? new Fill() : new NoFill();
        return shapeType.createShape(fillBehavior, color);
    }

    public MyShape createDefaultShape() {
        return ShapeType.RECTANGULAR_SHAPE.createShape(new Fill(),Color.BLUE);
    }
}
