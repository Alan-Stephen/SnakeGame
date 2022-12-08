import com.example.snakeproject.Model.SnakeModel;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeModelTest {

    private final int SPEED_XY = 5;
    @Test
    public void testOutOfBoundsOrigin(){
        SnakeModel snakeModel = new SnakeModel(0,0);
        snakeModel.outofBounds();
        assertEquals(snakeModel.getActive(),false);
    }
    @Test
    public void testOutOfBoundsBottomLeft(){
        SnakeModel snakeModel = new SnakeModel(870,560);
        snakeModel.outofBounds();
        assertEquals(snakeModel.getActive(),false);
    }

    @Test
    public void testOutOfBoundsNormal(){
        SnakeModel snakeModel = new SnakeModel(300,300);
        snakeModel.outofBounds();
        assertEquals(snakeModel.getActive(),true);
    }

    @Test
    public void testOutOfBoundsTopLeft(){
        SnakeModel snakeModel = new SnakeModel(870,0);
        snakeModel.outofBounds();
        assertEquals(snakeModel.getActive(),false);
    }

    @Test
    public void testOutOfBoundsBottomRight(){
        SnakeModel snakeModel = new SnakeModel(0,570);
        snakeModel.outofBounds();
        assertEquals(snakeModel.getActive(),false);
    }

    @Test
    public void testOutOfBoundsInvalidPosition(){
        SnakeModel snakeModel = new SnakeModel(-10, -10);
        snakeModel.outofBounds();

        assertEquals(snakeModel.getActive(),false);
    }

    @Test
    public void testSnakeModelKeyNoKeyPressed(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        assertEquals(snakeModel.getDirection(), SnakeModel.DIRECTION.right);
    }

    @Test
    public void testSnakeModelKeyUpPressed(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        snakeModel.keyPressed(KeyCode.UP);

        assertEquals(snakeModel.getDirection(), SnakeModel.DIRECTION.up);
    }

    @Test
    public void testSnakeModelKeyDownPressed(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        snakeModel.keyPressed(KeyCode.DOWN);

        assertEquals(snakeModel.getDirection(), SnakeModel.DIRECTION.down);
    }

    @Test
    public void testSnakeModelKeyLeftPressedWhileRight(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        snakeModel.keyPressed(KeyCode.LEFT);

        assertEquals(snakeModel.getDirection(), SnakeModel.DIRECTION.right);
    }

    @Test
    public void testSnakeModelKeyDownPressedWhileUp(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        snakeModel.keyPressed(KeyCode.UP);
        snakeModel.keyPressed(KeyCode.DOWN);

        assertEquals(snakeModel.getDirection(), SnakeModel.DIRECTION.up);
    }

    @Test
    public void testSnakeModelKeyUpPressedWhileDown(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        snakeModel.keyPressed(KeyCode.DOWN);
        snakeModel.keyPressed(KeyCode.UP);

        assertEquals(snakeModel.getDirection(), SnakeModel.DIRECTION.down);
    }

    @Test
    public void testSnakeModelKeyRightPressedWhileLeft() {
        SnakeModel snakeModel = new SnakeModel(100,100);
        snakeModel.keyPressed(KeyCode.DOWN);
        snakeModel.keyPressed(KeyCode.LEFT);
        snakeModel.keyPressed(KeyCode.RIGHT);

        assertEquals(snakeModel.getDirection(), SnakeModel.DIRECTION.left);
    }

    @Test
    public void testSnakeModeDefault(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        snakeModel.move();
        System.out.println(snakeModel.getDirection().ordinal());
        assertEquals(snakeModel.getX(), 105);
        assertEquals(snakeModel.getY(), 100);
    }

    @Test
    public void testSnakeModeDown(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        snakeModel.keyPressed(KeyCode.DOWN);
        snakeModel.move();
        System.out.println(snakeModel.getDirection().ordinal());
        assertEquals(snakeModel.getX(), 100);
        assertEquals(snakeModel.getY(), 105);
    }

    @Test
    public void testSnakeModeUp(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        snakeModel.keyPressed(KeyCode.UP);
        snakeModel.move();
        System.out.println(snakeModel.getDirection().ordinal());
        assertEquals(snakeModel.getX(), 100);
        assertEquals(snakeModel.getY(), 95);
    }

    @Test
    public void testSnakeModeLeft(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        snakeModel.keyPressed(KeyCode.DOWN);
        snakeModel.keyPressed(KeyCode.LEFT);

        snakeModel.move();
        System.out.println(snakeModel.getDirection().ordinal());
        assertEquals(snakeModel.getX(), 95);
        assertEquals(snakeModel.getY(), 100);
    }

}