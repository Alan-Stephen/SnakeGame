package com.example.snakeproject.Controllers;

import com.example.snakeproject.BrickModel;
import com.example.snakeproject.BrickView;
import com.example.snakeproject.Model.FoodModel;
import com.example.snakeproject.Model.SnakeModel;
import com.example.snakeproject.Views.BombView;
import com.example.snakeproject.Views.FoodView;
import com.example.snakeproject.Views.Theme;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;


// Todo: SEPERATE VIEW FROM LOGIC IN HERE? maybe have all the code at the end
public class FoodFeastGamemode extends Gamemode{

    public FoodFeastGamemode(Theme theme, GraphicsContext gc,
                             SnakeModel snakeModel,
                             GameType.Difficulty difficulty) {
        super(theme,gc,snakeModel, difficulty);
        for(int i = 0; i < 4; i++){
            foods.add(new FoodModel());
            foodsView.add(new FoodView());
        }
    }
}
