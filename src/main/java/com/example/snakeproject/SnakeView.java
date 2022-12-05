package com.example.snakeproject;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.LinkedList;

public class SnakeView extends ViewEntity {

    ImageUtil util = ImageUtil.getInstance();

    public int bodyPointSpacing;
    private final int SPEED_XY = 5;

    private Image snakeHead;
    private Image newImgSnakeHead;

    private GameUtil gUtil = GameUtil.getInstance();

    public SnakeView(String headPath, String bodyPath){
        snakeHead = util.getImage(headPath);
        newImgSnakeHead = snakeHead;
        this.setI(util.getImage("snake-body"));
        bodyPointSpacing  = (int) (getI().getWidth() / SPEED_XY);

    }

    public void resetHead(){
        this.newImgSnakeHead = this.snakeHead;
    }

    public void keyPressed(KeyEvent e, SnakeModel.Direction direction){
        System.out.println("changed direction");
        switch (e.getCode())
        {
            case UP:
                if (direction == SnakeModel.Direction.down) {}
                else {  newImgSnakeHead =
                        gUtil.rotateImage(snakeHead, -90);}
                break;

            case DOWN:
                if (direction == SnakeModel.Direction.up) {}
                else {  newImgSnakeHead =
                        gUtil.rotateImage(snakeHead, 90);
                }
                break;

            case LEFT:
                if (direction == SnakeModel.Direction.right) {}
                else { newImgSnakeHead =
                        gUtil.rotateImage(snakeHead, -180);
                }
                break;

            case RIGHT:
                if (direction == SnakeModel.Direction.left) {}
                else { newImgSnakeHead = snakeHead;
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
            Point2D point = bodyPoints.get(i);
            g.drawImage(this.getI(), point.getX(), point.getY());
        }
    }
}
