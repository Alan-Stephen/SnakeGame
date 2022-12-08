package com.example.snakeproject.Model;

import com.example.snakeproject.Views.ImageUtil;
import javafx.scene.image.Image;

import java.util.Random;


/**
 * ModelEntity for food. is intialised to random location and has method
 * to check if it has been eaten.
 * */
public class FoodModel extends ModelEntity
{

	private final int FOOD_SIZE = 25;

	private static final long serialVersionUID = -3641221053272056036L;


	/**
	 * generates food at random location with random icon. and sets
	 * width and height of the food object so collisions can be calculated
	 * */
	public FoodModel()	{
		setActive(true);

		this.setW(FOOD_SIZE);
		this.setH(FOOD_SIZE);

		this.setX((int) (Math.random() * (870 - getW() + 10)));
		this.setY((int) (Math.random() * (560 - getH() - 40)));
	}

	/**
	 * checks if snake has touched food, if it has increments snake length and score.
	 * */
	public void eaten(SnakeModel mySnake)	{

		if (mySnake.getRectangle().intersects(this.getRectangle().getBoundsInParent())
				&& getActive() && mySnake.getActive()) {
			setActive(false);
			mySnake.changeLength(mySnake.getLength() + 1);
			mySnake.setScore(mySnake.getScore() + 521);
		}
	}
}
