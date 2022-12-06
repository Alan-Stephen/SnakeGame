package com.example.snakeproject.Controllers;


import com.example.snakeproject.*;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    public Button closeButton;
    @FXML
    AnchorPane gameScene;

    @FXML
    Canvas canvas;

    @FXML
    ImageView background;


    AnimationTimer timer;

    private SnakeModel snakeModel = new SnakeModel(100,100);
    private Theme theme = new
            Theme("gameBackground0","snake1");


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

    public void stopGame(){
        timer.stop();
    }

    public void startGame() {

         timer = new AnimationTimer() {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            Gamemode gameLoop = new DefaultGamemode(theme,gc,snakeModel);
             int frame = 0;
            FoodModel foodModel = new FoodModel();

            @Override
            public void handle(long l) {
                gameLoop.handle(l);
            }
        };
        timer.start();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        closeButton.setFocusTraversable(false);
        background.setImage(theme.getBackground());
    }
}
