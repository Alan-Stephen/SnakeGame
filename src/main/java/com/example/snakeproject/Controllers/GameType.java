package com.example.snakeproject.Controllers;

public class GameType {

    private GameOption gameType = GameOption.normal;
    private Difficulty difficulty = Difficulty.easy;

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
