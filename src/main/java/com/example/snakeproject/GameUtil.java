package com.example.snakeproject;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * Helper class with methods to handle images.
 * */
public class GameUtil
{
	/**
	 * returns image from path ImagePath
	 * @param imagePath path to get image from.
	 * */
	public static Image getImage(String imagePath)
	{
		Image i = null;
		try
		{
			i = new Image(imagePath);
		} catch (Exception e)
		{
			System.err.println("VILLA : FINN EKKI TILTEKNA MYNDIN !\n");
			e.printStackTrace();
		}

		return i;
	}

	/**
	 * rotates an iamge and returns it
	 * @param degree angle to rotate image
	 * @param i image to rotate.
	 * */
	public static Image rotateImage(final Image i, final int degree) {
		ImageView image = new ImageView(i);
		image.setRotate(degree);

		SnapshotParameters snapshot = new SnapshotParameters();

		snapshot.setFill(Color.TRANSPARENT);
		return image.snapshot(snapshot,null);
	}
}
