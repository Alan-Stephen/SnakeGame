package com.example.snakeproject.Controllers;

/**
 * class to repersent an Entry for the LeaderBoard, needed as TableView requires
 * a class with getters to repersent an entry into the leaderboard.
 * */
public class LeaderBoardEntry {
    private String name;
    private int score;

    public int getScore() {
        return score;
    }

    public String getName(){return name;}
    public LeaderBoardEntry(String name, int score, int rank) {
        this.name = name;
        this.score = score;
    }
}
