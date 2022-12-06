package com.example.snakeproject;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.LinkedList;

public class Theme {

    Image background;
    SnakeView snake;

    FoodView food;

    ImageUtil util = ImageUtil.getInstance();
    public Theme(String bgPath, String snakeType){
        food = new FoodView();
        String snakePath = null;
        String bodyPath = null;
        background = util.getImage(bgPath);
        switch (snakeType){
            case "snake2" -> {
                snakePath = "snake_head_right_2";
                bodyPath = "snake_body_2";
            }
            case "snake3" -> {
                snakePath = "snake_head_right_3";
                bodyPath = "snake_body_3";
            }
            default -> {
                snakePath = "snake_head_right";
                bodyPath = "snake_body";
            }
        }
        this.snake = new SnakeView(snakePath,bodyPath);
    }
    public void drawSnake(GraphicsContext gc, int x, int y,
                          LinkedList<Point2D> bodyPoints){
        snake.draw(gc,x,y);
        snake.drawBody(gc,bodyPoints);
    }

    public SnakeView getSnakeView(){
        return snake;
    }

    public FoodView getFoodView(){
        return food;
    }

    public Image getBackground() {
        return background;
    }

    public void drawFood(GraphicsContext gc, int x, int y){
        food.draw(gc,x,y);
    }

    public void resetFood(){
        food = new FoodView();
    }

}
