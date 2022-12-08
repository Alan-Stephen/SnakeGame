package com.example.snakeproject.Model;

import com.example.snakeproject.Views.ImageUtil;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.LinkedList;


/**
 * Logical repersentation of the snake has methods to handle key presses,
 * movement, collisions with body, checking if out of bounds and updating
 * body points.
 * */

public class SnakeModel extends ModelEntity {

    private final int CANVAS_WIDTH = 870;
    private final int CANVAS_HEIGHT = 560;
    private int length;
    private final int SPEED_XY = 5;
    private SimpleIntegerProperty score = new SimpleIntegerProperty(0);

    // a linked list of points to repersent essentially where the snake
    // has been, it is trimmed by updateBodyPoints to only hold a bodyPoints
    // up to a certain length: length*bodyPointSpacing
    private LinkedList<Point2D> bodyPoints = new LinkedList<>();
    private DIRECTION direction = DIRECTION.right;

    public LinkedList<Point2D> getBodyPoints() {
        return bodyPoints;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public int getScore() {
        return score.get();
    }

    public SimpleIntegerProperty scoreProperty() {
        return score;
    }

    public void setScore(int score) {
        this.score.set(score);
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {return length;}

    // set length
    public void changeLength(int length) {this.length = length;}

    /** Spawns snake at specified parameters and sets width and height of snake
     * head.
     * @param x x coord of spawned snake
     * @param y y cord of spawned snake
     *
     * */
    public SnakeModel(int x, int y) {
        setActive(true);
        Image i = ImageUtil.getInstance().getImage("snake_head_right");
        this.setX(x);
        this.setY(y);
        this.setW((int) i.getWidth());
        this.setH((int) i.getHeight());

        this.length = 1;
    }

    /**
     * update bodyPoints according to the snakes current position
     *
     * @param bodyPointSpacing the size of a body point essentially used to
     *                         measure how far away each body point should be
     *                         from one another
     * */
    public void updateBodyPoints(int bodyPointSpacing){
        bodyPoints.add(new Point2D(getX(), getY()));

        if (bodyPoints.size() == (length + 1) * bodyPointSpacing)
        {
            bodyPoints.remove(0);
        }
    }
    /**
     * calls outOfBounds and eatBody
     * */
    public void checkIfAlive(){
        outofBounds();
        eatBody();
    }

    /**
     * handles controls, rotates snake head appropriate direction when key
     * pressed by changing the value of direction variable
     *
     * @param e KeyEvent object used by method to figure out what key was
     *          pressed
     * */
    public void keyPressed(KeyEvent e) {
        // athugaðu lykilinn
        switch (e.getCode())
        {
            case UP:
                if (direction == DIRECTION.down) {}
                else { direction = DIRECTION.up;
                }
                break;

            case DOWN:
                if (direction == DIRECTION.up) {}
                else { direction = DIRECTION.down;
                }
                break;

            case LEFT:
                if (direction == DIRECTION.right) {}
                else { direction = DIRECTION.left;
                }
                break;

            case RIGHT:
                if (direction == DIRECTION.left) {}
                else { direction = DIRECTION.right;
                }

            default:
                break;
        }
    }


    /** changes position of the snake depending on what direction
     * direction variable is
     * */
    public void move() {
        switch (direction){
            case down -> setY(getY() + SPEED_XY);
            case left ->  setX(getX() - SPEED_XY);
            case up -> setY(getY() - SPEED_XY);
            case right -> setX(getX() + SPEED_XY);
        }
    }


    //@Override

    /**
     * iterates through all points in bodyPoints to see if any points in
     * body points are equal to another points in bodypoints whilst not
     * being the same point object. if it is the case that a point in body
     * points equals another point then active is set to false.
     * */
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
     * checks if snake position is out of bounds if so sets active to false.
     */
    public void outofBounds()
    {
        boolean xOut = (getX() <= 0 || getX() >= (CANVAS_WIDTH));
        boolean yOut = (getY() <= 0 || getY() >= (CANVAS_HEIGHT));
        if (xOut || yOut) {
            setActive(false);
        }
    }

    public enum DIRECTION {
        up,
        down,
        left,
        right
    }
}



