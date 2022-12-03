package com.example.snakeproject;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class GameKeyListener implements EventHandler<KeyEvent> {

    private SnakeModel mySnake;
    private SnakeView snakeView;

    GameKeyListener(SnakeModel mySnake,SnakeView snakeView){
        this.mySnake = mySnake;
        this.snakeView = snakeView;
    }
    @Override
    //TODO : move the keypressed logic somewhere else
    public void handle(KeyEvent keyEvent) {
        snakeView.keyPressed(keyEvent,mySnake.direction);
        mySnake.keyPressed(keyEvent);
    }
}
