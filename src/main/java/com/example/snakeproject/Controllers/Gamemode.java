package com.example.snakeproject.Controllers;

import com.example.snakeproject.Model.BrickModel;
import com.example.snakeproject.Views.BrickView;
import com.example.snakeproject.Model.FoodModel;
import com.example.snakeproject.Model.SnakeModel;
import com.example.snakeproject.Views.FoodView;
import com.example.snakeproject.Views.Theme;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

/**
 * Class to handle default gamemode game loop e.g one food, no bombs, borders
 * kill
 * */
public class Gamemode  {

    private final int CANVAS_WIDTH = 870;

    private final int CANVAS_HEIGHT = 560;

    private final int BRICK_CAPACITY = 20;

    private final int BRICK_MULT = 10;

    private final int FOOD_CAPACITY = 15;
    GraphicsContext gc;
    Theme theme;

    int frame = 0;

    SnakeModel snakeModel;

    ArrayList<BrickModel> bricks = new ArrayList(BRICK_CAPACITY );
    ArrayList<BrickView> bricksView = new ArrayList<>(BRICK_CAPACITY);
    ArrayList<FoodModel> foods = new ArrayList(FOOD_CAPACITY );
    ArrayList<FoodView> foodsView = new ArrayList<>(FOOD_CAPACITY);

    /**
     * adds  1 food and foodView to foods and foodsView also generates bricks
     * equal to 10 * difficulty.ordinal (0 for easy, 1 for medium, 2 for hard)
     * adds generated bricks to respective array list.
     *
     * @param theme theme instance to use to draw the snake and score
     * @param gc GraphicsContext to draw to, essentially canvas to draw to.
     * @param snakeModel instance of SnakeModel to move / handle
     * @param difficulty self-explanatory difficulty
     * */
    Gamemode(Theme theme, GraphicsContext gc,
             SnakeModel snakeModel, GameType.Difficulty difficulty){
        this.theme = theme;
        this.gc = gc;
        this.snakeModel = snakeModel;

        foods.add(new FoodModel());
        foodsView.add(new FoodView());

        System.out.println("DIFFICULTY : " + difficulty.ordinal());
        for(int i = 0; i < BRICK_MULT * difficulty.ordinal(); i++){
            bricks.add(new BrickModel());
            bricksView.add(new BrickView());
        }
    }

    /**
     * draws snake,food and score on canvas and deals updates models frame to
     * frame.
     * @param l l should be passed through from AnimationTimer.handle(l)
     * */
    public void handle(long l){

        // code is only run every other frame (to keep code to original 30fps)
        frame++;
        if(frame % 2 == 0){}
        else{return;}

        // is snake is not alive code is not run.
        if(snakeModel.getActive()){}
        else{return;}

        // clear canvas
        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);


        theme.drawSnake(gc, snakeModel.getX(),
                snakeModel.getY(), snakeModel.getBodyPoints());

        // draws food and checks if it has been eaten, generates new food if it
        // has been
        for(int i = 0; i < foods.size(); i++) {
            FoodModel foodModel = foods.get(i);
            FoodView foodView = foodsView.get(i);
            if (foodModel.getActive()) {
                foodView.draw(gc,foodModel.getX(), foodModel.getY());
                foodModel.eaten(snakeModel);
            } else {
                foods.set(i,new FoodModel());
                foodsView.set(i,new FoodView());
            }
        }

        // draws brick and check if they have collided with snake
        for(int i = 0; i < bricks.size();i++){
            BrickModel brick = bricks.get(i);
            bricksView.get(i).draw(gc,brick.getX(),brick.getY());
            brick.eaten(snakeModel);
        }

        theme.drawScore(gc, snakeModel.getScore());
        snakeModel.move();
        snakeModel.updateBodyPoints(theme.getSnakeView().getBodyPointSpacing());
        snakeModel.checkIfAlive();
    }
}
