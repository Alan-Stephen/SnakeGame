package com.example.snakeproject;

import javafx.scene.image.Image;

import java.util.Random;


// TODO : MAKE FOOD FACTORY?
/**
 * Explains itself.
 * */
public class FoodModel extends ModelEntity
{

	private static final long serialVersionUID = -3641221053272056036L;


	/**
	 * generates food at random location with random icon.
	 * */
	public FoodModel()	{
		setActive(true);

		System.out.println(new Random().nextInt(10));
		Image i = ImageUtil.getInstance().getImage((String.valueOf(new Random().nextInt(10))));

		this.setW((int) i.getWidth());
		this.setH((int) i.getHeight());

		this.setX((int) (Math.random() * (870 - getW() + 10)));
		this.setY((int) (Math.random() * (560 - getH() - 40)));
	}

	/**
	 * checks if snake has touched food, if it has increments snake length and score.
	 * */
	public void eaten(SnakeModel mySnake)	{

		if (mySnake.getRectangle().intersects(this.getRectangle().getBoundsInParent())
				&& getActive() && mySnake.getActive()) {
			System.out.println("yay");
			setActive(false);
			mySnake.changeLength(mySnake.getLength() + 1);
			mySnake.score += 521;
		}
	}

	/**
	 * draws food icon
	 * */
}
