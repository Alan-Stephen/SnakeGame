package com.example.snakeproject;

import javafx.scene.canvas.GraphicsContext;

public class GamemodeFactory {

    public Gamemode getGamemode(String gameType, Theme theme,
                                GraphicsContext gc, SnakeModel snakeModel){

        if(gameType == "gamemode1"){
            return new ImmortalGamemode(theme,gc,snakeModel);
        } else if(gameType == "gamemode2"){
            return  new FoodFeastGamemode(theme,gc,snakeModel);
        } else if (gameType == "gamemode3") {
            return new DeadlyFoodGamemode(theme,gc,snakeModel);
        }
        return new DefaultGamemode(theme,gc,snakeModel);
    }
}
