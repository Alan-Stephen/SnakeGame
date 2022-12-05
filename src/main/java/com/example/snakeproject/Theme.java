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
    public Theme(String bgPath, String snakePath, String bodyPath){
        food = new FoodView();
        background = util.getImage(bgPath);
        snake = new SnakeView(snakePath,bodyPath);
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
