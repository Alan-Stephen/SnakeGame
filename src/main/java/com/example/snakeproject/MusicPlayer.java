package com.example.snakeproject;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Random;
import java.awt.Graphics2D;

import javazoom.jl.player.Player;

/**
 * Plays music in seperate thread
 *
 * */
public class MusicPlayer extends Thread
{
	private String filename;
	public Player player;

	/**
	 * @param filename file to play music from
	 * */
	public MusicPlayer(String filename)
	{
		this.filename = filename;
	}

	/**
	 * Plays music specified in filename in seperate thread
	 * */
	public void play()
	{
		new Thread()
		{
			@Override
			public void run()
			{
				super.run();
				try
				{
					//BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
					player = new Player(new BufferedInputStream(new FileInputStream(filename)));
					player.play();

				} catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
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
