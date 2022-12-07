package com.example.snakeproject.Controllers;

import com.example.snakeproject.Model.SnakeModel;
import com.example.snakeproject.Views.SnakeView;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class GameKeyListener implements EventHandler<KeyEvent> {

    private final SnakeModel mySnake;
    private final SnakeView snakeView;

    public GameKeyListener(SnakeModel mySnake, SnakeView snakeView){
        this.mySnake = mySnake;
        this.snakeView = snakeView;
    }
    @Override
    public void handle(KeyEvent keyEvent) {
        snakeView.keyPressed(keyEvent,mySnake.getDirection());
        mySnake.keyPressed(keyEvent);
    }
}
