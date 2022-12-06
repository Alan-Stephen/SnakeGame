package com.example.snakeproject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DefaultGamemode implements Gamemode{

    final int CANVAS_WIDTH = 870;

    final int CANVAS_HEIGHT = 560;
    GraphicsContext gc;
    Theme theme;

    int frame = 0;

    SnakeModel snakeModel;

    FoodModel foodModel = new FoodModel();
    public DefaultGamemode(Theme theme, GraphicsContext gc, SnakeModel snakeModel) {
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
                snakeModel.getY(), snakeModel.getBodyPoints());

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
        snakeModel.checkIfAlive();
    }

    public void drawScore(GraphicsContext g,int score){
        g.setFont(new Font("Comic Sans", 30));
        g.setFill(Color.MAGENTA);
        g.strokeText("SCORE : " + score, 20, 40);
    }

}
