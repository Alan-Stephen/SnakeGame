package com.example.snakeproject.Controllers;

import com.example.snakeproject.Model.SnakeModel;
import com.example.snakeproject.Views.Theme;
import javafx.scene.canvas.GraphicsContext;

/**
 * Factory class to generate a gamemode depending on the gameType specified.
 * */
public class GamemodeFactory {

    /**
     * @return gamemode associated with passed in gameType
     *
     * @param theme theme instance to use to draw the snake and score
     * @param gc GraphicsContext to draw to, essentially canvas to draw to.
     * @param snakeModel instance of SnakeModel to move / handle
     * @param gameType game type of the gamemode to be returned.
     * */
    public Gamemode getGamemode(Theme theme, GraphicsContext gc,
                                SnakeModel snakeModel, GameType gameType){

        if(gameType.getGameType() == GameType.GameOption.immortal){
            return new ImmortalGamemode(theme,gc,snakeModel);
        } else if(gameType.getGameType() == GameType.GameOption.feast){
            return  new FoodFeastGamemode(theme,gc,snakeModel,
                    gameType.getDifficulty());
        } else if (gameType.getGameType() == GameType.GameOption.deadlyFood) {
            return new DeadlyFoodGamemode(theme,gc,snakeModel,
                    gameType.getDifficulty());
        }
        return new Gamemode(theme,gc,snakeModel,gameType.getDifficulty());
    }
}
