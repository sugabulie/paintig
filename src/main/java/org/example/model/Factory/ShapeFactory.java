package org.example.model.Factory;

import org.example.model.MyShape;
import org.example.model.fill.Fill;
import org.example.model.fill.FillBehavior;
import org.example.model.fill.NoFill;

import java.awt.*;


public class ShapeFactory {
    private static ShapeFactory instance;
    private final ShapeState defaultShape;

    private ShapeFactory() {
        defaultShape=ShapeState.getInstance();
    }

    public static ShapeFactory getInstance() {
        synchronized (ShapeFactory.class) {
            if (instance == null) {
                instance = new ShapeFactory();
            }
            return instance;
        }
    }

    public MyShape createShape(){
        return defaultShape.getShapeType().createShape(defaultShape.isFill()?new Fill():new NoFill(),defaultShape.getColor());
    }


    public MyShape createDefaultShape() {
        return ShapeType.RECTANGULAR_SHAPE.createShape(new NoFill(),Color.BLUE);
    }
}
