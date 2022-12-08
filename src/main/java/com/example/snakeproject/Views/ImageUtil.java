package com.example.snakeproject.Views;

import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

/**
 * Singleton class used to acesss images using a hashmap
 * */

public class ImageUtil {
	private static ImageUtil instance;
	private ImageUtil(){}

	/**
	 * @return returns instance of ImageUitl
	 * */
	public static ImageUtil getInstance(){
		if(instance == null){
			instance = new ImageUtil();
		}
		return instance;
	}

	/**
	 * @param path key used in hashmap.
	 * @return image from hashmap based on key path
	 * */
	//
	public Image getImage(String path){
		return images.get(path);
	}

	GameUtil util = GameUtil.getInstance();
	private final Map<String, Image> images = new HashMap<>();
	{
		// snake
		images.put("snake_head_right", util.
				getImage("snake-head-right.png"));
		images.put("snake_body", util.getImage("snake-body.png"));
		// obstacles
		images.put("0", util.getImage("food-kiwi.png"));
		images.put("1", util.getImage("food-lemon.png"));
		images.put("2", util.getImage("food-litchi.png"));
		images.put("3", util.getImage("food-mango.png"));
		images.put("4", util.getImage("food-apple.png"));
		images.put("5", util.getImage("food-banana.png"));
		images.put("6", util.getImage("food-blueberry.png"));
		images.put("7", util.getImage("food-cherry.png"));
		images.put("8", util.getImage("food-durian.png"));
		images.put("9", util.getImage("food-grape.png"));
		images.put("10", util.getImage("food-grapefruit.png"));
		images.put("11", util.getImage("food-peach.png"));
		images.put("12", util.getImage("food-pear.png"));
		images.put("13", util.getImage("food-orange.png"));
		images.put("14", util.getImage("food-pineapple.png"));
		images.put("15", util.getImage("food-strawberry.png"));
		images.put("16", util.getImage("food-watermelon.png"));
		images.put("gameBackground0", util.
				getImage("gameBackground0.png"));
		images.put("game-scene-01", util.
				getImage("game-scene-01.jpg"));
		images.put("gameBackground1", util.
				getImage("gameBackground1.png"));
		images.put("gameBackground2", util.
				getImage("gameBackground2.jpg"));
		images.put("gameBackground3", util.
				getImage("gameBackground3.jpg"));
		images.put("snake_head_right_2", util.
				getImage("snake-head-right_2.png"));
		images.put("snake_head_right_3", util.
				getImage("snake-head-right_3.png"));
		images.put("snake_body_2", util.getImage("snake-body_2.png"));
		images.put("snake_body_3", util.getImage("snake-body_3.png"));
		images.put("bomb", util.getImage("bomb.png"));
		images.put("brick", util.getImage("brick.png"));
		images.put("icon", util.getImage("snake-logo.png"));
	}
}
