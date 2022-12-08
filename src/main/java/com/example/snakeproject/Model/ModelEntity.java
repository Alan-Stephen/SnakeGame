package com.example.snakeproject.Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.shape.Rectangle;


/**
 * parent class for the model port of objects which appear on the GUI.
 * can repersent their height,width, location on screen and the space they
 * take up as a rectangle so collisions can be calculated.
 * */
public abstract class ModelEntity {
    private int x,y,h,w;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public boolean getActive() {
        return active.get();
    }

    public BooleanProperty activeProperty() {
        return active;
    }

    public void setActive(boolean active) {
        this.active.set(active);
    }

    // property so it's state can be tracked.
    private SimpleBooleanProperty active = new SimpleBooleanProperty();

    /**
     * returns rectangle object describing its position and the area it takes
     * up on te screen.
     * */
    public Rectangle getRectangle()
    {
        return new Rectangle(x, y, w, h);
    }
}
