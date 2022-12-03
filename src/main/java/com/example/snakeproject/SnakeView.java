package com.example.snakeproject;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.LinkedList;

public class SnakeView extends ViewEntity {

    ImageUtil util = ImageUtil.getInstance();

    int bodyPointSpacing;
    private final int SPEED_XY = 5;
    private final Image IMG_SNAKE_HEAD =
            util.getImage("snake-head-right");

    private static Image newImgSnakeHead;

    private GameUtil gUtil = GameUtil.getInstance();

    public SnakeView(){
        newImgSnakeHead = IMG_SNAKE_HEAD;
        this.setI(util.getImage("snake-body"));
        bodyPointSpacing  = (int) (getI().getWidth() / SPEED_XY);

    }

    public void drawScore(GraphicsContext g,int score){
        g.setFont(new Font("Comic Sans", 30));
        g.setFill(Color.MAGENTA);
        g.strokeText("SCORE : " + score, 20, 40);
    }

    public void keyPressed(KeyEvent e, SnakeModel.Direction direction){
        switch (e.getCode())
        {
            case UP:
                if (direction == SnakeModel.Direction.down) {}
                else {  newImgSnakeHead =
                        gUtil.rotateImage(IMG_SNAKE_HEAD, -90);}
                break;

            case DOWN:
                if (direction == SnakeModel.Direction.up) {}
                else {  newImgSnakeHead =
                        gUtil.rotateImage(IMG_SNAKE_HEAD, 90);
                }
                break;

            case LEFT:
                if (direction == SnakeModel.Direction.right) {}
                else { newImgSnakeHead =
                        gUtil.rotateImage(IMG_SNAKE_HEAD, -180);
                }
                break;

            case RIGHT:
                if (direction == SnakeModel.Direction.left) {}
                else { newImgSnakeHead = IMG_SNAKE_HEAD;
                }
            default:
                break;
        }
    }

    public void draw(GraphicsContext g,int x,int y) {
        g.drawImage(newImgSnakeHead, x,y);
    }

    public void drawBody(GraphicsContext g,LinkedList<Point2D> bodyPoints) {
        int length = (bodyPoints.size() - 1 - bodyPointSpacing);

        for (int i = length; i >= bodyPointSpacing ; i -= bodyPointSpacing) {
            Point2D point = bodyPoints.get((int)i);
            g.drawImage(this.getI(), point.getX(), point.getY());
        }
    }
}
