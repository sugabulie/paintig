package org.example.model.Factory;

import lombok.Getter;
import org.example.controller.Controller;
import org.example.view.MenuCreator;

import java.awt.*;
import java.util.Objects;

@Getter
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

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }
}
