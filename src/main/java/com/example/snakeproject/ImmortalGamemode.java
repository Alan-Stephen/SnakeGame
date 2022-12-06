package com.example.snakeproject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;

public class ImmortalGamemode implements Gamemode{


    final int CANVAS_WIDTH = 870;

    final int CANVAS_HEIGHT = 560;
    GraphicsContext gc;
    Theme theme;

    int frame = 0;

    SnakeModel snakeModel;

    FoodModel foodModel = new FoodModel();
    public ImmortalGamemode(Theme theme, GraphicsContext gc, SnakeModel snakeModel) {
        this.theme = theme;
        this.gc = gc;
        this.snakeModel = snakeModel;
    }

    @Override
    public void handle(long l) {
        frame++;
        if(frame % 2 == 0){}
        else{return;}

        if(snakeModel.getActive()){}
        else{return;}

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
        drawScore(gc, snakeModel.getScore());
        snakeModel.move();
        snakeModel.updateBodyPoints(theme.getSnakeView().getBodyPointSpacing());
        toOpposite(snakeModel);
    }

    public void drawScore(GraphicsContext g, int score){
        g.setFont(new Font("Comic Sans", 30));
        g.setFill(Color.MAGENTA);
        g.strokeText("SCORE : " + score, 20, 40);
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
