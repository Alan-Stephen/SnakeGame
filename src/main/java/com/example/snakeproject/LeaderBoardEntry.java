package com.example.snakeproject;

public class LeaderBoardEntry {
    private String name;
    private int score;

    public LeaderBoardEntry(String name, int score, int rank) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
