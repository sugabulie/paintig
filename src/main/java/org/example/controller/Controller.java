package org.example.controller;

import lombok.Getter;
import org.example.controller.action.Action;
import org.example.controller.action.ActionDraw;
import org.example.model.Factory.ShapeFactory;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.fill.NoFill;
import org.example.view.MenuCreator;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class Controller {
    private static Controller instance;
    @Getter
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
        model.setDrawableShape(shape);
        action = new ActionDraw (model);


        panel = new MyPanel(this);
        MenuCreator menuCreator=MenuCreator.getInstance(this);
        JMenuBar menuBar=menuCreator.createMenu();
        JToolBar jToolBar=menuCreator.createToolBar(JToolBar.VERTICAL);
        jMenuBar=menuCreator.createMenu();
        model.addObserver(panel);


        frame = new MyFrame();
        frame.setPanel(panel);
        frame.setJMenuBar(jMenuBar);
        frame.setJMenuBar(menuBar);
        frame.add(jToolBar,BorderLayout.EAST);
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
