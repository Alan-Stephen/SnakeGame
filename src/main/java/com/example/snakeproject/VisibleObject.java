package com.example.snakeproject;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;


public abstract class VisibleObject {
    double x;
    double y;
    Image i;
    double w;
    double h;

    private SimpleBooleanProperty l = new SimpleBooleanProperty();

    public boolean isL() {
        return l.get();
    }

    public BooleanProperty lProperty() {
        return l;
    }

    public void setL(boolean l) {
        this.l.set(l);
    }

    public abstract void draw(GraphicsContext g);

    public Rectangle getRectangle()
    {
        return new Rectangle(x, y, w, h);
    }
}
