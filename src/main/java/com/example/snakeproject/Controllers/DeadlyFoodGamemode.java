package com.example.snakeproject.Controllers;

import com.example.snakeproject.Model.BombModel;
import com.example.snakeproject.Model.SnakeModel;
import com.example.snakeproject.Views.BombView;
import com.example.snakeproject.Views.Theme;
import javafx.scene.canvas.GraphicsContext;

/**
 * Gamemode which generates bombs which if touched snake is killed,
 *  the bombs get reset and moved every 2000 frames.
 * */
public class DeadlyFoodGamemode extends FoodFeastGamemode{

    private final int NUM_FOOD = 5;
    private final int BOMB_START = 5;
    private final int NUM_BOMBS = 5;
    /**
     * calls parent class constructor but then adds NUM_BOMB amount of
     * bombs to food array.
     *
     * @param theme theme to draw snake and food with
     * @param gc   graphics context to draw to
     * @param snakeModel SnakeModel to act on
     * @param difficulty difficulty of gamemode
     * */
    public DeadlyFoodGamemode(Theme theme, GraphicsContext gc,
                              SnakeModel snakeModel,
                              GameType.Difficulty difficulty) {
        super(theme, gc, snakeModel,difficulty);
        for (int i = 0; i < NUM_BOMBS; i++) {
            foods.add(new BombModel());
            foodsView.add(new BombView());
        }
    }



    /**
     * calls parent class handle(l) but then resets bombs if frame is divisble
     * by 2000
     *
     * @param l l should be passed through AnimationTimer.handle(l)
     * */
    @Override
    public void handle(long l){
        super.handle(l);
        if(frame % 2000 == 0){
            for(int i = BOMB_START; i < NUM_FOOD + NUM_BOMBS - 1;i++){
                foods.set(i, new BombModel());
            }
        }
    }
}