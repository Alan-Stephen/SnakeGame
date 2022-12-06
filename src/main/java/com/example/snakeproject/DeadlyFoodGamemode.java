package com.example.snakeproject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class DeadlyFoodGamemode extends FoodFeastGamemode{

    public DeadlyFoodGamemode(Theme theme, GraphicsContext gc, SnakeModel snakeModel) {
        super(theme, gc, snakeModel);
        for (int i = 0; i < 5; i++) {
            foods.add(new BombModel());
            foodsView.add(new BombView());
        }
    }

    @Override
    public void handle(long l){
        super.handle(l);
        if(frame % 1000 == 0){
            for(int i = 5; i < 9;i++){
                foods.set(i, new BombModel());
            }
        }
    }
}