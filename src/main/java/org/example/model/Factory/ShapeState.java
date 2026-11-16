package org.example.model.Factory;

import org.example.controller.Controller;
import org.example.view.MenuCreator;

import java.awt.*;
import java.util.Objects;

public class ShapeState {

    private static ShapeState instance;

    public static ShapeState getInstance(){
        synchronized (ShapeState.class){
            if(instance==null){
                instance=new ShapeState(ShapeType.RECTANGULAR_SHAPE,Color.BLUE,true);
            }
            return instance;
        }
    }

    private ShapeType shapeType;
    private Color color;
    private boolean fill;

    public ShapeState(ShapeType shapeType, Color color,boolean isFill){
        this.shapeType= Objects.requireNonNull(shapeType);
        this.color = Objects.requireNonNullElse(color, Color.BLACK);
        this.fill=isFill;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }
}
