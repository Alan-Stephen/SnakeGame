package com.example.snakeproject;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.LinkedList;

// MORE MVC HERE , remove snake head
/**
 * Handles game controls and drawing of the snake.
 * */

public class SnakeModel extends ModelEntity {
    private int length;
    public int score = 0;
    public LinkedList<Point2D> bodyPoints = new LinkedList<>();
    public Direction direction = Direction.right;

    /** Spawns snake at specified parameters.
     * @param x x coord of spawned snake
     * @param y y cord of spawned snake
     *
     * */
    public SnakeModel(int x, int y) {
        setActive(true);
        Image i = ImageUtil.getInstance().getImage("snake-head-right");
        this.setX(x);
        this.setY(y);
        this.setW((int) i.getWidth());
        this.setH((int) i.getHeight());

        this.length = 1;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {return length;}

    // set length
    public void changeLength(int length) {this.length = length;}


    public void updateBodyPoints(int bodyPointSpacing){
        bodyPoints.add(new Point2D(getX(), getY()));

        if (bodyPoints.size() == (length + 1) * bodyPointSpacing)
        {
            bodyPoints.remove(0);
        }
    }

    public void update(int bodyPointSpacing){
        checkIfAlive();
        move();
        updateBodyPoints(bodyPointSpacing);
    }

    public void checkIfAlive(){
        outofBounds();
        eatBody();
    }

    /**
     * handles controls, rotates snake head appropriate direction when key pressed.
     * */
    public void keyPressed(KeyEvent e) {
        // athugaðu lykilinn
        switch (e.getCode())
        {
            case UP:
                if (direction == Direction.down) {}
                else { direction = Direction.up;
                    // newImgSnakeHead = GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);
                }
                break;

            case DOWN:
                if (direction == Direction.up) {}
                else { direction = Direction.down;
                    // newImgSnakeHead = GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
                }
                break;

            case LEFT:
                if (direction == Direction.right) {}
                else { direction = Direction.left;
                    // newImgSnakeHead = GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);
                }
                break;

            case RIGHT:
                if (direction == Direction.left) {}
                else { direction = Direction.right;
                    // newImgSnakeHead = IMG_SNAKE_HEAD;
                }

            default:
                break;
        }
    }


    /** changes velocity of snake depending on what key is pressed.
     * */
    public void move() {
        // Leikjabreytan.
        int SPEED_XY = 5;
        switch (direction){
            case down -> setY(getY() + SPEED_XY);
            case left ->  setX(getX() - SPEED_XY);
            case up -> setY(getY() - SPEED_XY);
            case right -> setX(getX() + SPEED_XY);
        }
    }


    //@Override

    /** checks if two body points have colided if so ests l = false	*/
    public void eatBody()
    {
        for (Point2D point : bodyPoints)
        {
            for (Point2D point2 : bodyPoints)
            {
                if (point.equals(point2) && point != point2)
                {
                    setActive(false);
                }
            }
        }
    }

    /**
     * checks if snake position is out of bounds if so sets l.false.
     */
    private void outofBounds()
    {
        boolean xOut = (getX() <= 0 || getX() >= (870));
        boolean yOut = (getY() <= 0 || getY() >= (560));
        if (xOut || yOut)
        {
            setActive(false);
        }
    }

    public static enum Direction {
        up,
        down,
        left,
        right
    }
}



