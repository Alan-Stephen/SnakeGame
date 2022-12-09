package com.example.snakeproject.Views;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.LinkedList;

/**
 * Class holding Snake and food views so that the task of drawing can be
 * abstracted. Theme instances should be used to draw images on canvas.
 * */
public class Theme {

    private Image background;
    private SnakeView snake;

    private FoodView food;

    public SnakeView getSnakeView(){
        return snake;
    }

    public FoodView getFoodView(){
        return food;
    }

    public Image getBackground() {
        return background;
    }

    private ImageUtil util = ImageUtil.getInstance();
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

    public void drawFood(GraphicsContext gc, int x, int y){
        food.draw(gc,x,y);
    }

    public void resetFood(){
        food = new FoodView();
    }
    public void drawScore(GraphicsContext g,int score){
        g.setFont(new Font("Comic Sans", 30));
        g.setFill(Color.MAGENTA);
        g.strokeText("SCORE : " + score, 20, 40);
    }

}
