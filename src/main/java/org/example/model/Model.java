package org.example.model;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {
    private MyShape drawableShape;
    private List<MyShape> shapeList;

    public Model() {
        this.shapeList = new ArrayList<>();
    }

    public void changeShape(Point2D x, Point2D y) {
        drawableShape.setFrame(x, y);
        this.setChanged();
        this.notifyObservers();

    }

    public void addShape(MyShape shape){
        drawableShape=shape;
        shapeList.add(shape);
    }

    public void draw(Graphics2D g) {
        drawableShape.draw(g);
        shapeList.forEach(shape->shape.draw(g));
    }

    public void setDrawableShape(MyShape drawableShape) {
        this.drawableShape = drawableShape;
    }
}
