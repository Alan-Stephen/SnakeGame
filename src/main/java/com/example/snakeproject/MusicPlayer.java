package com.example.snakeproject;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;
import java.awt.Graphics2D;


import javafx.application.Platform;
import javafx.scene.media.MediaPlayer;
import javazoom.jl.player.Player;

import javafx.scene.media.Media;

/**
 * Plays music in seperate thread
 *
 * */
public class MusicPlayer extends Thread {
	private Media file;

	MediaPlayer player;

	/**
	 * @param filename file to play music from
	 * */
	public MusicPlayer(String filename) {
		file = new Media(new File(filename).toURI().toString());
		player = new MediaPlayer(file);
		player.setCycleCount(1);
	}

	/**
	 * Plays music specified in filename in seperate thread
	 * */
	public void play()
	{
		Platform.runLater(() -> {
			try {
				player.play();

			} catch (Exception e) {
				System.out.println(e);
			}
		});
	}

	public void stopMusic(){
		player.stop();
	}
	public void loopMusic(){
		player.setCycleCount(99);
	}

	/**
	 * Plays music without creation of instance
	 * @param filename location of music to play
	 * */
	public static void getMusicPlay(String filename)
	{
		MusicPlayer musicPlayer = new MusicPlayer(filename);
		musicPlayer.play();
	}
}
