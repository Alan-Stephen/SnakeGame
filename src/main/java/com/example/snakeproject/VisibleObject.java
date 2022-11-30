package com.example.snakeproject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;


public abstract class VisibleObject {
    double x;
    double y;
    Image i;
    int w;
    int h;

    public boolean l; //not necesary


    public abstract void draw(GraphicsContext g);

    public Rectangle getRectangle()
    {
        return new Rectangle(x, y, w, h);
    }
}
