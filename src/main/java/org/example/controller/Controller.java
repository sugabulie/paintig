package org.example.controller;

import lombok.Getter;
import org.example.controller.action.Action;
import org.example.controller.action.ActionDraw;
import org.example.controller.action.AppAction;
import org.example.model.Factory.ShapeFactory;
import org.example.model.Factory.ShapeType;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.fill.Fill;
import org.example.model.fill.NoFill;
import org.example.view.MenuCreator;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import javax.swing.*;
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
    private Action action;
    @Getter
    private final JMenuBar jMenuBar;



    private Controller() {
        model = new Model();
        shapeFactory =ShapeFactory.getInstance();
        MyShape shape = shapeFactory.createDefaultShape();
        shape.setFb(new NoFill());
        model.setDrawableShape(shape);
        action = new ActionDraw (model);

        panel = new MyPanel(this);
        MenuCreator menuCreator=MenuCreator.getInstance(this);
        jMenuBar=menuCreator.createMenu();
        model.addObserver(panel);


        frame = new MyFrame();
        frame.setPanel(panel);
        frame.setJMenuBar(jMenuBar);
    }
    public void mousePressed(Point2D p){
        action.mousePressed((Point) p);
    }
    public void mouseDragged(Point2D p){
        action.mouseDragged((Point) p);
    }

    public static void getInstance(){
        if (instance==null){
            instance= new Controller();
        }
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }

    public void switchActionDraw(){
        action= new ActionDraw(model);
    }
}
