package com.example.snakeproject.Controllers;

import com.example.snakeproject.BrickModel;
import com.example.snakeproject.BrickView;
import com.example.snakeproject.Model.BombModel;
import com.example.snakeproject.Model.SnakeModel;
import com.example.snakeproject.Views.BombView;
import com.example.snakeproject.Views.FoodView;
import com.example.snakeproject.Views.Theme;
import javafx.scene.canvas.GraphicsContext;

public class DeadlyFoodGamemode extends FoodFeastGamemode{

    private final int BOMB_START = 5;
    private final int NUM_BOMBS = 5;
    public DeadlyFoodGamemode(Theme theme, GraphicsContext gc,
                              SnakeModel snakeModel,
                              GameType.Difficulty difficulty) {
        super(theme, gc, snakeModel,difficulty);
        for (int i = 0; i < NUM_BOMBS; i++) {
            foods.add(new BombModel());
            foodsView.add(new BombView());
        }
    }

    @Override
    public void handle(long l){
        super.handle(l);
        if(frame % 2000 == 0){
            for(int i = BOMB_START; i < 9;i++){
                foods.set(i, new BombModel());
            }
        }
    }
}