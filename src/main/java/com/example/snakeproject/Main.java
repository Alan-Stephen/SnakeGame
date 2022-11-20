package com.example.snakeproject;
/**
 * main class
 * */

// TODO: move main class from play to this file.
public class Main {
    public static void main(String[] args)
    {
        new Play().loadFrame();
        MusicPlayer.getMusicPlay("src/main/resources/frogger.mp3");
    }
}