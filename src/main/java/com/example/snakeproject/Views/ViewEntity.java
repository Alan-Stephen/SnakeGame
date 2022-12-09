package com.example.snakeproject.Views;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javax.swing.text.View;
import javax.swing.text.html.parser.Entity;

/**
 * abstract class used to repersent any object visible on the game screen
 * */
public abstract class ViewEntity {

    private Image i;

    public Image getI() {
        return i;
    }

    public void setI(Image i) {
        this.i = i;
    }

    public abstract void draw(GraphicsContext gc, int x, int y);
}
