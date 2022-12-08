package com.example.snakeproject.Controllers;

import com.example.snakeproject.Model.FoodModel;
import com.example.snakeproject.Model.SnakeModel;
import com.example.snakeproject.Views.FoodView;
import com.example.snakeproject.Views.Theme;
import javafx.scene.canvas.GraphicsContext;


/**
 * Subclass of gamemode where there are multiple food instances instead of just
 * one, e.g multiple foods on game scene, if food is eaten new food is generated
 * */
public class FoodFeastGamemode extends Gamemode{

    private final int NUM_FOOD = 4;

    /**
     * calls parent constructor but then additionally adds NUM_FOOD amounts of
     * food to food arraylists
     *
     * @param theme theme instance to use to draw the snake and score
     * @param gc GraphicsContext to draw to, essentially canvas to draw to.
     * @param snakeModel instance of SnakeModel to move / handle
     * @param difficulty self-explanatory difficulty
     * */
    public FoodFeastGamemode(Theme theme, GraphicsContext gc,
                             SnakeModel snakeModel,
                             GameType.Difficulty difficulty) {
        super(theme,gc,snakeModel, difficulty);
        for(int i = 0; i < NUM_FOOD; i++){
            foods.add(new FoodModel());
            foodsView.add(new FoodView());
        }
    }
}
