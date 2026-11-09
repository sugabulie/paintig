package org.example.controller;

import org.example.model.Factory.ShapeFactory;
import org.example.model.Factory.ShapeType;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.fill.NoFill;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import java.awt.*;
import java.awt.geom.Point2D;

public class Controller {
    private static Controller instance;
    private final Model model;
    private final MyFrame frame;
    private final MyPanel panel;
    private Point2D firstPoint;
    private Point2D secondPoint;
    private ShapeFactory shapeFactory;



    private Controller() {
        model = new Model();
        shapeFactory = new ShapeFactory();
        MyShape shape = shapeFactory.createShape(ShapeType.RECTANGULAR_SHAPE, Color.BLUE);
        shape.setFb(new NoFill());
        model.setDrawableShape(shape);

        panel = new MyPanel(this);

        model.addObserver(panel);


        frame = new MyFrame();
        frame.setPanel(panel);
    }
    public void mousePressed(Point2D p){
        MyShape shape =shapeFactory.createShape(ShapeType.RECTANGULAR_SHAPE,Color.BLUE);
        model.addShape(shape);
        firstPoint = p;
    }
    public void mouseDragged(Point2D p){
        secondPoint = p;
        model.changeShape(firstPoint, secondPoint);
    }

    public static void getInstance(){
        if (instance==null){
            instance= new Controller();
        }
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
