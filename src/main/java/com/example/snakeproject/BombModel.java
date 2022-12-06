package com.example.snakeproject;

import javafx.scene.image.Image;

import java.util.Random;

public class BombModel extends FoodModel{

    BombModel(){
        setActive(true);

        System.out.println(new Random().nextInt(10));
        Image i = ImageUtil.getInstance().getImage("0");

        this.setW((int) i.getWidth());
        this.setH((int) i.getHeight());

        this.setX((int) (Math.random() * (870 - getW() + 10)));
        this.setY((int) (Math.random() * (560 - getH() - 40)));
    }

    @Override
    public void eaten(SnakeModel mySnake)	{

        if (mySnake.getRectangle().intersects(this.getRectangle().getBoundsInParent())
                && getActive() && mySnake.getActive()) {
            setActive(false);
            mySnake.setActive(false);
        }
    }
}
