package com.example.snakeproject.Controllers;

import com.example.snakeproject.Model.FoodModel;
import com.example.snakeproject.Model.SnakeModel;
import com.example.snakeproject.Views.Theme;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ImmortalGamemode extends Gamemode {


    final int CANVAS_WIDTH = 870;

    final int CANVAS_HEIGHT = 560;

    FoodModel foodModel = new FoodModel();
    public ImmortalGamemode(Theme theme, GraphicsContext gc,
                            SnakeModel snakeModel) {
        super(theme,gc,snakeModel, GameType.Difficulty.easy);
    }

    @Override
    public void handle(long l) {
        frame++;
        if(frame % 2 == 0){}
        else{
            return;
        }
        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        theme.drawSnake(gc, snakeModel.getX(),
                snakeModel.getY(),snakeModel.getBodyPoints());

        if(foodModel.getActive()){
            theme.drawFood(gc,foodModel.getX(), foodModel.getY());
            foodModel.eaten(snakeModel);
        } else{
            foodModel = new FoodModel();
            theme.resetFood();
        }
        theme.drawScore(gc, snakeModel.getScore());
        snakeModel.move();
        snakeModel.updateBodyPoints(theme.getSnakeView().getBodyPointSpacing());
        toOpposite(snakeModel);
    }
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
