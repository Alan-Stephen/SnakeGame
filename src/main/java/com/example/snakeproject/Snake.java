package com.example.snakeproject;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Handles game controls and drawing of the snake.
 * */

public class Snake extends VisibleObject
{
    // Leikjabreytan.
    private int speed_XY;
    private int length;
    private int num;
    public int score = 0;

    private static final Image IMG_SNAKE_HEAD = ImageUtil.images.get("snake-head-right");

    public List<Point2D> bodyPoints = new LinkedList<>();

    private static Image newImgSnakeHead;
    boolean up, down, left, right = true;

    /** Spawns snake at specified parameters.
     * @param x x coord of spawned snake
     * @param y y cord of spawned snake
     *
     * */
    public Snake(int x, int y)
    {
        setL(true);
        this.x = x;
        this.y = y;
        this.i = ImageUtil.images.get("snake-body");
        this.w = (int) i.getWidth();
        this.h = (int) i.getHeight();

        this.speed_XY = 5;
        this.length = 1;

        /*
         * Attention : ?
         */
        this.num = (int) (w / speed_XY);
        newImgSnakeHead = IMG_SNAKE_HEAD;

    }

    public int getLength()
    {
        return length;
    }

    // set length
    public void changeLength(int length)
    {
        this.length = length;
    }

    /**
     * handles controls, rotates snake head appropriate direction when key pressed.
     * */
    public void keyPressed(KeyEvent e)
    {
        // athugaðu lykilinn
        switch (e.getCode())
        {
            case UP:
                if (!down)
                {
                    up = true;
                    down = false;
                    left = false;
                    right = false;

                    newImgSnakeHead = GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);
                }
                break;

            case DOWN:
                if (!up)
                {
                    up = false;
                    down = true;
                    left = false;
                    right = false;

                    newImgSnakeHead = GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
                }
                break;

            case LEFT:
                if (!right)
                {
                    up = false;
                    down = false;
                    left = true;
                    right = false;

                    newImgSnakeHead = GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);

                }
                break;

            case RIGHT:
                if (!left)
                {
                    up = false;
                    down = false;
                    left = false;
                    right = true;

                    newImgSnakeHead = IMG_SNAKE_HEAD;
                }

            default:
                break;
        }
    }


    /** changes velocity of snake depending on what key is pressed.
     *
     * */
    public void move()
    {
        // láta kvikindið hreyfa sig
        if (up)
        {
            y -= speed_XY;
        } else if (down)
        {
            y += speed_XY;
        } else if (left)
        {
            x -= speed_XY;
        } else if (right)
        {
            x += speed_XY;
        }

    }


    /** checks if outOfBounds or if it's eaten it's body.
     * controls movement by dynamically deleting and adding bodyPoints
     * handles movement changes.
     * */
    @Override
    public void draw(GraphicsContext g)
    {
        outofBounds();
        eatBody();

        bodyPoints.add(new Point2D(x, y));

        if (bodyPoints.size() == (this.length + 1) * num)
        {
            bodyPoints.remove(0);
        }
        g.drawImage(newImgSnakeHead, x, y);
        drawBody(g);

        move();
    }

    /** checks if two body points have colided if so ests l = false	*/
    public void eatBody()
    {
        for (Point2D point : bodyPoints)
        {
            for (Point2D point2 : bodyPoints)
            {
                if (point.equals(point2) && point != point2)
                {
                    setL(false);
                }
            }
        }
    }


    /** Draws the snake bodyPoints.
     *
     * */
    public void drawBody(GraphicsContext g) {
        int length = (bodyPoints.size() - 1 - num);


        System.out.println("Length :" + length + " size: " + bodyPoints.size() +" num: " + num);
        for (int i = length; i >= num ; i -= num) {
            Point2D point = bodyPoints.get((int)i);
            g.drawImage(this.i, point.getX(), point.getY());
        }
    }

    public void drawScore(GraphicsContext g){
        g.setFont(new Font("Comic Sans", 30));
        g.setFill(Color.MAGENTA);
        g.strokeText("SCORE : " + score, 20, 40);
    }

    /**
     * checks if snake position is out of bounds if so sets l.false.
     */
    private void outofBounds()
    {
        boolean xOut = (x <= 0 || x >= (870));
        boolean yOut = (y <= 0 || y >= (560));
        if (xOut || yOut)
        {
            setL(false);
        }
    }
}


// probably a hint on how to implement this, maybe data repersentation of this.
/*public class Snake {
	
		private static final long serialVersionUID = -3641221053272056036L;


    // TODO: það þarf endurnýjun

    public static int moving;

    public static int move(int x) {
        moving = x;
        return moving;
    }

    public static void stop() {
        moving = 0;
    }
}*/


