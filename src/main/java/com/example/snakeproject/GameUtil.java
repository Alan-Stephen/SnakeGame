package com.example.snakeproject;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Helper class with methods to handle images.
 * */

public class GameUtil {

	private static GameUtil instance;

	public static GameUtil getInstance() {
		if(instance == null){
			instance = new GameUtil();
		}
		return instance;
	}

	private GameUtil(){};
	/**
	 * returns image from path ImagePath
	 * @param imagePath path to get image from.
	 * */
	public Image getImage(String imagePath)
	{
		Image i = null;
		try
		{
			i = new Image(imagePath);
		} catch (Exception e)
		{
			System.err.printf("ERROR : IMAGE %s NOT FOUND \n",imagePath);
			e.printStackTrace();
		}

		return i;
	}

	/**
	 * rotates an iamge and returns it
	 * @param degree angle to rotate image
	 * @param i image to rotate.
	 * */
	public Image rotateImage(final Image i, final int degree) {
		ImageView image = new ImageView(i);
		image.setRotate(degree);

		SnapshotParameters snapshot = new SnapshotParameters();

		snapshot.setFill(Color.TRANSPARENT);
		return image.snapshot(snapshot,null);
	}
}
