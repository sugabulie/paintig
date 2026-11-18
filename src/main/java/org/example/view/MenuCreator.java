package org.example.view;

import lombok.Setter;
import org.example.controller.Controller;
import org.example.model.Factory.ShapeState;
import org.example.model.Factory.ShapeType;
import org.example.view.menu.AppCommand;
import org.example.view.menu.CommandActionListener;
import org.example.view.menu.SwitchFill;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

public class MenuCreator {
    private static MenuCreator instance;
    @Setter
    private Controller controller;
    private final ShapeState shapeState = ShapeState.getInstance();
    private JRadioButtonMenuItem fillItem;
    private JRadioButtonMenuItem noFillItem;

    private MenuCreator(Controller controller){
        this.controller=controller;

    }
    public static MenuCreator getInstance(Controller controller){
        synchronized (MenuCreator.class){
            if(instance==null){
                instance=new MenuCreator(controller);
            }
            return instance;
        }
    }


    public JMenuBar createMenu(){
        JMenuBar menuBar=new JMenuBar();
        JMenu shapeMenu=createShapeMenu();
        JMenu colorMenu=createColorMenu();
        JMenu fillMenu=createFillMenu();
        JMenu actionMenu=createActionMenu();
        menuBar.add(shapeMenu);
        menuBar.add(colorMenu);
        menuBar.add(fillMenu);
        menuBar.add(actionMenu);

        return menuBar;
    }

    public JToolBar createToolBar(int orientation){
        ArrayList<Action> actionArrayList= createToolBarItems();
        JToolBar jToolBar=new JToolBar(orientation);
        actionArrayList.forEach(jToolBar::add);
        return jToolBar;

    }

    private ArrayList<Action> createToolBarItems() {
        ArrayList<Action> menuItems=new ArrayList<>();
        URL colorUrl = getClass().getClassLoader().getResource("fill_16x16.png");
        ImageIcon fillIco = colorUrl == null ? null : new ImageIcon(colorUrl);
        AppCommand fillCommand = new SwitchFill( true, shapeState,fillItem,noFillItem);
        menuItems.add(new CommandActionListener("Заливка", fillIco, fillCommand));
        return menuItems;
    }

    private JMenu createActionMenu() {
        ButtonGroup group=new ButtonGroup();
        JMenu actionMenu=new JMenu("Действие");
        JRadioButtonMenuItem drawItem=new JRadioButtonMenuItem("Рисовать",true);
        drawItem.addActionListener(action ->controller.switchActionDraw());
        actionMenu.add(drawItem);
        group.add(drawItem);
        return actionMenu;
    }

    private JMenu createFillMenu() {
        ButtonGroup group=new ButtonGroup();
        JMenu fillMenu=new JMenu("Заливка");
        fillItem=new JRadioButtonMenuItem("С заливкой",true);
        noFillItem=new JRadioButtonMenuItem("Не с заливкой");
        fillItem.addActionListener(new CommandActionListener(new SwitchFill(true,shapeState,fillItem,noFillItem)));
        noFillItem.addActionListener(new CommandActionListener(new SwitchFill(true,shapeState,fillItem,noFillItem)));
        fillMenu.add(noFillItem);
        group.add(noFillItem);
        fillMenu.add(fillItem);
        group.add(fillItem);

        return fillMenu;
    }

    private JMenu createColorMenu() {
        ButtonGroup group =new ButtonGroup();
        JMenu colorMenu=new JMenu("Цвет");

        JRadioButtonMenuItem redItem=new JRadioButtonMenuItem("Красный");
        redItem.addActionListener(action ->shapeState.setColor(Color.RED));
        JRadioButtonMenuItem blueItem=new JRadioButtonMenuItem("Синий");
        blueItem.addActionListener(action ->shapeState.setColor(Color.BLUE));
        JRadioButtonMenuItem rgbItem=new JRadioButtonMenuItem("Выбор цвета");
        rgbItem.addActionListener(action ->shapeState.setColor(JColorChooser.showDialog(null,"Выбор цвета",Color.BLACK)));
        colorMenu.add(rgbItem);
        group.add(rgbItem);
        colorMenu.add(blueItem);
        group.add(blueItem);
        colorMenu.add(redItem);
        group.add(redItem);


        return colorMenu;
    }

    private JMenu createShapeMenu() {
        ButtonGroup group =new ButtonGroup();
        JMenu shapeMenu=new JMenu("Фигура");

        JRadioButtonMenuItem squareItem=new JRadioButtonMenuItem("Прямоугольник",true);
        squareItem.addActionListener(action ->shapeState.setShapeType(ShapeType.RECTANGULAR_SHAPE));
        shapeMenu.add(shapeMenu);
        group.add(shapeMenu);

        return shapeMenu;
    }

}
