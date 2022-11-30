package com.example.snakeproject;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    AnchorPane gameScene;

    @FXML
    Canvas canvas;

    Snake mySnake = new Snake(100,100);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Image background = ImageUtil.images.get("UI-background");
        Image fail = ImageUtil.images.get("game-scene-01");

        AnimationTimer loop = new AnimationTimer() {
            int frame = 0;
            Food food = new Food();

            GraphicsContext gc = canvas.getGraphicsContext2D();
            @Override
            public void handle(long l) {
                frame++;
                if(frame % 2 == 0){
                    gc.drawImage(background, 0, 0);
                    if (mySnake.l)
                    {
                        mySnake.draw(gc);
                        if (food.l)
                        {
                            food.draw(gc);
                            food.eaten(mySnake);
                        } else
                        {
                            food = new Food();
                        }
                    } else
                    {
                        gc.drawImage(fail, 0, 0);
                    }
                    mySnake.drawScore(gc);
                }

            }
        };
        loop.start();

    }
}
