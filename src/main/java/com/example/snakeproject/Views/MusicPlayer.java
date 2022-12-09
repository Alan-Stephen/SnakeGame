package com.example.snakeproject.Views;


import java.io.File;


import javafx.application.Platform;
import javafx.scene.media.MediaPlayer;

import javafx.scene.media.Media;

/**
 * Class to handle playing sounds and music.
 *
 * */
public class MusicPlayer extends Thread {
	private Media file;

	private MediaPlayer player;

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

	/**
	 * stops music being played in player.
	 * */
	public void stopMusic(){
		player.stop();
	}

	/**
	 * loops the music being played infinetely
	 * */
	public void loopMusic(){
		player.setCycleCount(Integer.MAX_VALUE);
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
