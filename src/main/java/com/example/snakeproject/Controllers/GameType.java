package com.example.snakeproject.Controllers;


/**
 * holds gameType and difficulty variables and Enums to use to describe
 * gamemode and difficulty.
 * */
public class GameType {

    private GameOption gameType;
    private Difficulty difficulty;

    public GameOption getGameType() {
        return gameType;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public enum GameOption{
        normal,
        immortal,
        feast,
        deadlyFood

    }
    public enum Difficulty {
        easy,
        medium,
        hard
    }

    GameType(GameOption gamemode, Difficulty difficulty){
        this.gameType = gamemode;
        this.difficulty = difficulty;
    }
}
