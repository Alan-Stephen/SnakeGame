package com.example.snakeproject;

import javafx.scene.canvas.GraphicsContext;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Image;


/**
 * Explains itself.
 * */
public class Food extends VisibleObject
{

	private static final long serialVersionUID = -3641221053272056036L;


	/**
	 * generates food at random location with random icon.
	 * */
	public Food()	{
		setL(true);

		this.i = ImageUtil.images.get(String.valueOf(new Random().nextInt(10)));

		this.w = i.getWidth();
		this.h = i.getHeight();

		this.x = (int) (Math.random() * (870 - w + 10));
		this.y = (int) (Math.random() * (560 - h - 40));
	}

	/**
	 * checks if snake has touched food, if it has increments snake length and score.
	 * */
	public void eaten(Snake mySnake)	{

		if (mySnake.getRectangle().intersects(getRectangle().getBoundsInParent()) && isL() && mySnake.isL())		{
			setL(false);
			mySnake.changeLength(mySnake.getLength() + 1);
			mySnake.score += 521;
		}
	}

	/**
	 * draws food icon
	 * */
	@Override
	public void draw(GraphicsContext g)
	{
		g.drawImage(i, x, y);
	}
}
