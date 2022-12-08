package com.example.snakeproject.Views;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

/**
 * visual repersentation of food.
 * */

public class FoodView extends ViewEntity {

    ImageUtil util = ImageUtil.getInstance();

    /**
     * generates random image of a fruit to use out of 10 different fruits.
     * */
    public FoodView(){
        setI(util.getImage((String.valueOf(new Random().nextInt(10)))));
    }

    /**
     * draws food at point x,y to GraphicsContext gc
     * @param x x position to draw to
     * @param y y position to draw to
     * @param gc GraphicsContext to draw image to.
     * */
    @Override
    public void draw(GraphicsContext gc, int x, int y) {
        gc.drawImage(this.getI(),x,y);
    }
}
