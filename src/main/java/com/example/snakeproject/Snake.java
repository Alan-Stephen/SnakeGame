package com.example.snakeproject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

/**
 * Handles game controls and drawing of the snake.
 * */

public class Snake extends MyFrame.SnakeObject
{
    // Leikjabreytan.
    private int speed_XY;
    private int length;
    private int num; // ? delete?
    public int score = 0;

    private static final BufferedImage IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.images.get("snake-head-right");

    public static List<Point> bodyPoints = new LinkedList<>();

    private static BufferedImage newImgSnakeHead;
    boolean up, down, left, right = true;

    /** Spawns snake at specified parameters.
     * @param x x coord of spawned snake
     * @param y y cord of spawned snake
     *
     * */
    public Snake(int x, int y)
    {
        this.l = true;
        this.x = x;
        this.y = y;
        this.i = ImageUtil.images.get("snake-body");
        this.w = i.getWidth(null);
        this.h = i.getHeight(null);

        this.speed_XY = 5;
        this.length = 1;

        /*
         * Attention : ?
         */
        this.num = w / speed_XY;
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
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if (!down)
                {
                    up = true;
                    down = false;
                    left = false;
                    right = false;

                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);
                }
                break;

            case KeyEvent.VK_DOWN:
                if (!up)
                {
                    up = false;
                    down = true;
                    left = false;
                    right = false;

                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
                }
                break;

            case KeyEvent.VK_LEFT:
                if (!right)
                {
                    up = false;
                    down = false;
                    left = true;
                    right = false;

                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);

                }
                break;

            case KeyEvent.VK_RIGHT:
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
    public void draw(Graphics g)
    {
        outofBounds();
        eatBody();

        bodyPoints.add(new Point(x, y));

        if (bodyPoints.size() == (this.length + 1) * num)
        {
            bodyPoints.remove(0);
        }
        g.drawImage(newImgSnakeHead, x, y, null);
        drawBody(g);

        move();
    }

    /** checks if two body points have colided if so ests l = false	*/
    public void eatBody()
    {
        for (Point point : bodyPoints)
        {
            for (Point point2 : bodyPoints)
            {
                if (point.equals(point2) && point != point2)
                {
                    this.l = false;
                }
            }
        }
    }


    /** Draws the snake bodyPoints.
     *
     * */
    public void drawBody(Graphics g)
    {
        int length = bodyPoints.size() - 1 - num;

        for (int i = length; i >= num; i -= num)
        {
            Point point = bodyPoints.get(i);
            g.drawImage(this.i, point.x, point.y, null);
        }
    }

    /**
     * checks if snake position is out of bounds.
     * */
    // checks if out of bounds and if so sets l = false
    private void outofBounds()
    {
        boolean xOut = (x <= 0 || x >= (870 - w));
        boolean yOut = (y <= 40 || y >= (560 - h));
        if (xOut || yOut)
        {
            l = false;
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


