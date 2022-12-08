package com.example.snakeproject.Views;

import com.example.snakeproject.Model.SnakeModel;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.LinkedList;

/**
 * class repersenting the visual aspects of the snake, has methods to draw
 * snake and handles rotation of head.
 * */
public class SnakeView extends ViewEntity {

    private final int RIGHT_ANGLE = 90;
    private final int FLIP_ANGLE = 190;

    private ImageUtil util = ImageUtil.getInstance();

    private int bodyPointSpacing;
    private final int SPEED_XY = 5;
    private Image snakeHead;
    private Image newImgSnakeHead;

    private GameUtil gUtil = GameUtil.getInstance();

    /**
     * @return space bewteen body points.
     * */
    public int getBodyPointSpacing(){return bodyPointSpacing;}

    /**
     * sets image for snakeHead and i (body image)
     * sets bodyPointSpacing value which is just width of body / speed
     *
     * @param headPath path needed to get head image
     * @param bodyPath path needed to get body image
     * */
    public SnakeView(String headPath, String bodyPath){
        snakeHead = util.getImage(headPath);
        newImgSnakeHead = snakeHead;
        this.setI(util.getImage(bodyPath));
        bodyPointSpacing  = (int) (getI().getWidth() / SPEED_XY);
    }

    /**
     * sets head to rotated to its default position of right
     * */
    public void resetHead(){
        this.newImgSnakeHead = this.snakeHead;
    }

    /**
     * rotates snake head, so it is facing the direction of movement.
     *
     * @param e KeyEvent instance used to get information about what key was
     *          pressed
     * @param direction direction of snake model.
     * */
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

    /**
     * draw snake head at point x,y using GraphicsContext g
     * @param x x position to draw at
     * @param y y position to draw at
     * @param g graphics context to draw to
     * */
    public void draw(GraphicsContext g,int x,int y) {
        g.drawImage(newImgSnakeHead, x,y);
    }

    /**
     * draws body points of snake using bodyPoints at g
     * @param g GraphicsContext to draw it
     * @param bodyPoints used to draw bodyPoints, bodyPoints is a path of where
     *                   the snake has been, body points are drawn at intervals
     *                   along this path
     * */
    public void drawBody(GraphicsContext g,LinkedList<Point2D> bodyPoints) {
        int length = (bodyPoints.size() - 1 - bodyPointSpacing);

        for (int i = length; i >= bodyPointSpacing ; i -= bodyPointSpacing) {
            Point2D point = bodyPoints.get(i);
            g.drawImage(this.getI(), point.getX(), point.getY());
        }
    }
}
