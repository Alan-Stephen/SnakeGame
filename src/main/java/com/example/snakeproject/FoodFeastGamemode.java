package com.example.snakeproject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;


// Todo: SEPERATE VIEW FROM LOGIC IN HERE? maybe have all the code at the end
public class FoodFeastGamemode implements Gamemode{

    final int CANVAS_WIDTH = 870;

    final int CANVAS_HEIGHT = 560;
    GraphicsContext gc;
    Theme theme;

    int frame = 0;

    SnakeModel snakeModel;

    ArrayList<FoodModel> foods = new ArrayList(15 );
    ArrayList<FoodView> foodsView = new ArrayList<>(15);
    public FoodFeastGamemode(Theme theme, GraphicsContext gc, SnakeModel snakeModel) {
        this.theme = theme;
        this.gc = gc;
        this.snakeModel = snakeModel;

        for(int i = 0; i < 4; i++){
            foods.add(new FoodModel());
            foodsView.add(new FoodView());
        }
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

        System.out.println(foods.size());
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
