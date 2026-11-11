package org.example.controller.action;

import org.example.model.Factory.ShapeFactory;
import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;

public class ActionDraw implements AppAction {

    private Point firstPoint;
    private Point secondPoint;

    public ActionDraw(Model model) {
        this.model = model;
        shapeFactory = ShapeFactory.getInstance();
    }

    private final Model model;
    private ShapeFactory shapeFactory;

    @Override
    public void mousePressed(Point point) {
        firstPoint = point;
        MyShape shape =shapeFactory.createDefaultShape();
        model.addShape(shape);
    }

    @Override
    public void mouseDragged(Point point) {
        secondPoint = point;
        model.changeShape(firstPoint, secondPoint);
    }
}
