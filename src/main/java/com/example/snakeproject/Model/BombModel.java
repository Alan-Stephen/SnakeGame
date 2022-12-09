package com.example.snakeproject.Model;

import com.example.snakeproject.Views.ImageUtil;
import javafx.scene.image.Image;

import java.util.Random;

/**
 * Model for bomb, extension of FoodModel, inherits it logical boundaries from
 * it. primary difference is if BombModel is eaten snake is killed.
 * */
public class BombModel extends FoodModel{

    /**
     * checks if snake has colided with bomb if it has sets aliveProperty of
     * snake to false.
     *
     * @param mySnake SnakeModel to use to see if it has colided with bomb.
     * */
    @Override
    public void eaten(SnakeModel mySnake)	{

        if (mySnake.getRectangle().intersects(this.getRectangle().getBoundsInParent())
                && getActive() && mySnake.getActive()) {
            setActive(false);
            mySnake.setActive(false);
        }
    }
}
