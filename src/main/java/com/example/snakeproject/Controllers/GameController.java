package com.example.snakeproject.Controllers;


import com.example.snakeproject.*;
import javafx.animation.AnimationTimer;
import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    AnchorPane gameScene;

    @FXML
    Canvas canvas;

    @FXML
    ImageView background;

    private SnakeModel snakeModel = new SnakeModel(100,100);
    private Theme theme = new
            Theme("gameBackground0","snake-head-right","snake-body");



    public SnakeModel getSnakeModel() {return snakeModel;}
    public SnakeView getSnakeView() {return theme.getSnakeView();}

    public boolean resetGame(){
        this.snakeModel = new SnakeModel(100,100);
        getSnakeView().resetHead();
        return true;
    }

    public void setTheme(Theme theme){
        this.theme = theme;
        background.setImage(theme.getBackground());
    }

    private void startGame() {
        AnimationTimer loop = new AnimationTimer() {
            int frame = 0;
            FoodModel foodModel = new FoodModel();
            GraphicsContext gc = canvas.getGraphicsContext2D();

            //rewrite to have less indentation
            @Override
            public void handle(long l) {
                frame++;
                if(frame % 2 == 0){}
                else{return;}

                if(snakeModel.getActive()){}
                else{return;}

                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

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
                snakeModel.updateBodyPoints(getSnakeView().bodyPointSpacing);
                snakeModel.checkIfAlive();
            }
        };
        loop.start();
    }

    public void drawScore(GraphicsContext g,int score){
        g.setFont(new Font("Comic Sans", 30));
        g.setFill(Color.MAGENTA);
        g.strokeText("SCORE : " + score, 20, 40);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background.setImage(theme.getBackground());
        startGame();
    }
}
