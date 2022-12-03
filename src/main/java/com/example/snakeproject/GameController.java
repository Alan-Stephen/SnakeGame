package com.example.snakeproject;

import javafx.animation.AnimationTimer;
import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    AnchorPane gameScene;

    @FXML
    Canvas canvas;

    private SnakeModel snakeModel = new SnakeModel(100,100);
    private SnakeView snakeView = new SnakeView();


    public SnakeModel getSnakeModel() {return snakeModel;}
    public SnakeView getSnakeView() {return snakeView;}

    public BooleanProperty snakeAliveProperty(){return snakeModel.activeProperty();}

    public boolean resetGame(){
        this.snakeModel = new SnakeModel(100,100);
        snakeView = new SnakeView();
        return true;
    }

    private void startGame() {
        ImageUtil util = ImageUtil.getInstance();
        Image background = util.getImage("UI-background");

        AnimationTimer loop = new AnimationTimer() {
            int frame = 0;
            FoodModel foodModel = new FoodModel();
            FoodView foodView = new FoodView();

            GraphicsContext gc = canvas.getGraphicsContext2D();

            //rewrite to have less indentation
            @Override
            public void handle(long l) {
                frame++;
                if(frame % 2 == 0){}
                else{return;}

                gc.drawImage(background, 0, 0);

                if(snakeModel.getActive()){}
                else{return;}

                snakeView.draw(gc, snakeModel.getX(), snakeModel.getY());
                snakeView.drawBody(gc, snakeModel.bodyPoints);

                if(foodModel.getActive()){
                    foodView.draw(gc,foodModel.getX(), foodModel.getY());
                    foodModel.eaten(snakeModel);
                } else{
                    foodModel = new FoodModel();
                    foodView = new FoodView();
                }
                //todo: move draw score to this class
                snakeView.drawScore(gc, snakeModel.score);
                snakeModel.move();
                snakeModel.updateBodyPoints(snakeView.bodyPointSpacing);
                snakeModel.checkIfAlive();
            }
        };
        loop.start();
    }

    // BUNCH OF FUCKING DRAW FUNCTIONS DOWN HERE

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startGame();
    }
}
