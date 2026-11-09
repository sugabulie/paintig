package org.example.model.Factory;

import org.example.model.MyShape;
import org.example.model.fill.Fill;
import org.example.model.fill.FillBehavior;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public enum ShapeType {
    RECTANGULAR_SHAPE{
        @Override
        public MyShape createShape(FillBehavior fillBehavior, Color color) {
            return new MyShape(color,new Fill(),new Rectangle2D.Double());
        }
    };

    public abstract MyShape createShape(FillBehavior fillBehavior, Color color);
}
