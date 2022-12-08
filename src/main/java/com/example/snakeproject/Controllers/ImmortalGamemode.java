package com.example.snakeproject.Controllers;

import com.example.snakeproject.Model.FoodModel;
import com.example.snakeproject.Model.SnakeModel;
import com.example.snakeproject.Views.Theme;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 * gamemode in which you cannot die, you can go through your bodypoints without
 * dying and reaching the border of your screen will lead to the opposite end
 * */
public class ImmortalGamemode extends Gamemode {


    final int CANVAS_WIDTH = 870;

    final int CANVAS_HEIGHT = 560;

    FoodModel foodModel = new FoodModel();
    /**
     * calls parent class constructor but with difficulty of easy, immortal
     * mode can only be played on easy.
     *
     * @param theme theme instance to use to draw the snake and score
     * @param gc GraphicsContext to draw to, essentially canvas to draw to.
     * @param snakeModel instance of SnakeModel to move / handle
     * */
    public ImmortalGamemode(Theme theme, GraphicsContext gc,
                            SnakeModel snakeModel) {
        super(theme,gc,snakeModel, GameType.Difficulty.easy);
    }

    /**
     * draws snake and food, moves snake and controls logic relating to snake
     * and draw.
     * @param l to be passed in through Animation.timer(l)
     * */
    @Override
    public void handle(long l) {
        frame++;
        if(frame % 2 == 0){}
        else{
            return;
        }

        // clear canvas
        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        // draw snake
        theme.drawSnake(gc, snakeModel.getX(),
                snakeModel.getY(),snakeModel.getBodyPoints());

        // draw food, check if eaten if it has spawn new food and reset foodView
        // so new image is used for food.
        if(foodModel.getActive()){
            theme.drawFood(gc,foodModel.getX(), foodModel.getY());
            foodModel.eaten(snakeModel);
        } else{
            foodModel = new FoodModel();
            theme.resetFood();
        }

        theme.drawScore(gc, snakeModel.getScore());

        // snake logic, move snake, update the body points and if snake is at
        // edge of screen teleport the snake to the otherside.
        snakeModel.move();
        snakeModel.updateBodyPoints(theme.getSnakeView().getBodyPointSpacing());
        toOpposite(snakeModel);
    }

    /**
     * teleports snake to opposite end if they are by border of screen.
     *
     * @param snake snake to affect
     * */
    public void toOpposite(SnakeModel snake){
        if(snake.getY() <= 0){
            snake.setY(560);
        } else if (snake.getY() >= 560) {
            snake.setY(0);
        } else if (snake.getX() <= 0) {
            snake.setX(870);
        } else if (snake.getX() >= 870) {
            snake.setX(0);
        }
    }

}
