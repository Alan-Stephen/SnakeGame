import com.example.snakeproject.Model.FoodModel;
import com.example.snakeproject.Model.SnakeModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodModelTest {
    @Test
    public void testEatenDefaultTest(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        FoodModel foodModel = new FoodModel();
        foodModel.setX(100);
        foodModel.setY(100);

        foodModel.eaten(snakeModel);

        assertEquals(foodModel.getActive(), false);
    }

    @Test
    public void testEatenBorderTest(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        FoodModel foodModel = new FoodModel();
        foodModel.setX(76);
        foodModel.setY(76);

        foodModel.eaten(snakeModel);

        assertEquals(foodModel.getActive(), false);
    }

    @Test
    public void testEatenOutOfBounds(){
        SnakeModel snakeModel = new SnakeModel(100,100);
        FoodModel foodModel = new FoodModel();
        foodModel.setX(10);
        foodModel.setY(10);

        foodModel.eaten(snakeModel);

        assertEquals(foodModel.getActive(), true);
    }
}
