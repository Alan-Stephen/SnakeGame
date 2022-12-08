package com.example.snakeproject.Controllers;

import com.example.snakeproject.Model.SnakeModel;
import com.example.snakeproject.Views.SnakeView;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;


/** Handles key presses affecting an instance of SnakeModel and SnakeView
 * */
public class GameKeyListener implements EventHandler<KeyEvent> {

    private final SnakeModel mySnake;
    private final SnakeView snakeView;

    /**
     * pass through instace of SnakeModel and SnakeView to call.
     *
     * @param mySnake SnakeModel instance to call keyPressed
     * @param snakeView SnakeView instnace to call keyPressed
     * */

    public GameKeyListener(SnakeModel mySnake, SnakeView snakeView){
        this.mySnake = mySnake;
        this.snakeView = snakeView;
    }

    /**
     * calls keyPressed for snakeView and mySnake, so they can update their
     * rotation, direction, movement
     *
     * @param keyEvent KeyEvent instance containg information about the key
     *                 pressed
     * */
    @Override
    public void handle(KeyEvent keyEvent) {
        snakeView.keyPressed(keyEvent,mySnake.getDirection());
        mySnake.keyPressed(keyEvent);
    }
}
