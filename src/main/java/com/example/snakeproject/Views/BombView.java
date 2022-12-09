package com.example.snakeproject.Views;

/**
 * subclass of FoodView, same functionality but image drawn is a bomb not food.
 * */
public class BombView extends FoodView  {
    public BombView(){
        setI(util.getImage(("bomb")));
    }

}
