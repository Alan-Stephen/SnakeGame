package com.example.snakeproject;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Image;


/**
 * Explains itself.
 * */
public class Food extends MyFrame.SnakeObject
{

	private static final long serialVersionUID = -3641221053272056036L;


	/**
	 * generates food at random location with random icon.
	 * */
	public Food()	{
		this.l = true;

		this.i = ImageUtil.images.get(String.valueOf(new Random().nextInt(10)));

		this.w = i.getWidth(null);
		this.h = i.getHeight(null);

		this.x = (int) (Math.random() * (870 - w + 10));
		this.y = (int) (Math.random() * (560 - h - 40));
	}

	/**
	 * checks if snake has touched food, if it has increments snake length and score.
	 * */
	public void eaten(MyFrame.MySnake mySnake)	{

		if (mySnake.getRectangle().intersects(this.getRectangle()) && l && mySnake.l)		{
			this.l = false;
			mySnake.changeLength(mySnake.getLength() + 1);
			mySnake.score += 521;
		}
	}

	/**
	 * draws food icon
	 * */
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(i, x, y, null);
	}
}
