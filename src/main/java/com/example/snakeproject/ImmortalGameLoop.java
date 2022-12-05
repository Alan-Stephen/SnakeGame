package com.example.snakeproject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;

public class ImmortalGameLoop implements GameLoop{


    final int CANVAS_WIDTH = 870;

    final int CANVAS_HEIGHT = 560;
    GraphicsContext gc;
    Theme theme;

    int frame = 0;

    SnakeModel snakeModel;

    FoodModel foodModel = new FoodModel();
    public ImmortalGameLoop(Theme theme, GraphicsContext gc, SnakeModel snakeModel) {
        this.theme = theme;
        this.gc = gc;
        this.snakeModel = snakeModel;
    }

    @Override
    public void handle(long l) {
        frame++;
        if(frame % 2 == 0){}
        else{return;}

        //if(snakeModel.getActive()){}
        //else{return;}

        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        theme.drawSnake(gc, snakeModel.getX(),
                snakeModel.getY(),snakeModel.bodyPoints);

        if(foodModel.getActive()){
            theme.drawFood(gc,foodModel.getX(), foodModel.getY());
            foodModel.eaten(snakeModel);
        } else{
            foodModel = new FoodModel();
            theme.resetFood();
        }
        drawScore(gc, snakeModel.score);
        snakeModel.move();
        snakeModel.updateBodyPoints(theme.getSnakeView().bodyPointSpacing);
        toOpposite(snakeModel);
    }

    public void drawScore(GraphicsContext g, int score){
        g.setFont(new Font("Comic Sans", 30));
        g.setFill(Color.MAGENTA);
        g.strokeText("SCORE : " + score, 20, 40);
    }

    public void toOpposite(SnakeModel snake){
        if(snake.getY() == 0){
            snake.setY(560);
        } else if (snake.getY() == 560) {
            snake.setY(0);
        } else if (snake.getX() == 0) {
            snake.setX(870);
        } else if (snake.getX() == 870) {
            snake.setX(0);
        }
    }

}
