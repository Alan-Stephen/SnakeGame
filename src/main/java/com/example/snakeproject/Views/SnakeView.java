package com.example.snakeproject.Views;

import com.example.snakeproject.Model.SnakeModel;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.LinkedList;

public class SnakeView extends ViewEntity {

    private final int RIGHT_ANGLE = 90;
    private final int FLIP_ANGLE = 190;

    private ImageUtil util = ImageUtil.getInstance();

    private int bodyPointSpacing;
    private final int SPEED_XY = 5;
    private Image snakeHead;
    private Image newImgSnakeHead;

    private GameUtil gUtil = GameUtil.getInstance();

    public int getBodyPointSpacing(){return bodyPointSpacing;}

    public SnakeView(String headPath, String bodyPath){
        System.out.println(headPath);
        System.out.println(bodyPath);
        snakeHead = util.getImage(headPath);
        newImgSnakeHead = snakeHead;
        this.setI(util.getImage(bodyPath));
        bodyPointSpacing  = (int) (getI().getWidth() / SPEED_XY);
    }

    public void resetHead(){
        this.newImgSnakeHead = this.snakeHead;
    }

    public void keyPressed(KeyEvent e, SnakeModel.DIRECTION direction){
        switch (e.getCode())
        {
            case UP:
                if (direction == SnakeModel.DIRECTION.down) {}
                else {
                    newImgSnakeHead =
                            gUtil.rotateImage(snakeHead, -RIGHT_ANGLE);
                }
                break;

            case DOWN:
                if (direction == SnakeModel.DIRECTION.up) {}
                else {
                    newImgSnakeHead =
                            gUtil.rotateImage(snakeHead, RIGHT_ANGLE);
                }
                break;

            case LEFT:
                if (direction == SnakeModel.DIRECTION.right) {}
                else {
                    newImgSnakeHead =
                            gUtil.rotateImage(snakeHead, -FLIP_ANGLE);
                }
                break;

            case RIGHT:
                if (direction == SnakeModel.DIRECTION.left) {}
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
