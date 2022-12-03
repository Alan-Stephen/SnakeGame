package com.example.snakeproject;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class FoodView extends ViewEntity {

    ImageUtil util = ImageUtil.getInstance();
    FoodView(){
        setI(util.getImage((String.valueOf(new Random().nextInt(10)))));
    }
    @Override
    public void draw(GraphicsContext gc, int x, int y) {
        gc.drawImage(this.getI(),x,y);
    }
}
