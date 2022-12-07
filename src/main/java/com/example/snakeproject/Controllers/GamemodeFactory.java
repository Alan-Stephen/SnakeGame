package com.example.snakeproject.Controllers;

import com.example.snakeproject.Model.SnakeModel;
import com.example.snakeproject.Views.Theme;
import javafx.scene.canvas.GraphicsContext;

public class GamemodeFactory {

    public Gamemode getGamemode(Theme theme, GraphicsContext gc,
                                SnakeModel snakeModel, GameType gameType){

        if(gameType.getGameType() == GameType.GameOption.immortal){
            System.out.println("immortal");
            return new ImmortalGamemode(theme,gc,snakeModel);
        } else if(gameType.getGameType() == GameType.GameOption.feast){
            System.out.println("feast");
            return  new FoodFeastGamemode(theme,gc,snakeModel,
                    gameType.getDifficulty());
        } else if (gameType.getGameType() == GameType.GameOption.deadlyFood) {
            System.out.println("deadly");
            return new DeadlyFoodGamemode(theme,gc,snakeModel,
                    gameType.getDifficulty());
        }
        return new Gamemode(theme,gc,snakeModel,gameType.getDifficulty());
    }
}
