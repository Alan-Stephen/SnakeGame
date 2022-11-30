package com.example.snakeproject;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class GameKeyListener implements EventHandler<KeyEvent> {

    private Snake mySnake;

    GameKeyListener(Snake mySnake){this.mySnake = mySnake;}
    @Override
    //TODO : move the keypressed logic somewhere else
    public void handle(KeyEvent keyEvent) {
        mySnake.keyPressed(keyEvent);
    }
}
