package com.example.snakeproject;

import com.example.snakeproject.Views.BombView;
import com.example.snakeproject.Views.ImageUtil;
import com.example.snakeproject.Views.ViewEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BrickView extends BombView {

    public BrickView(){
        super();
        setI(ImageUtil.getInstance().getImage("brick"));
    }

}
