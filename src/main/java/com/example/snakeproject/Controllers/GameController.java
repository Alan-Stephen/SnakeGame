package com.example.snakeproject.Controllers;


import com.example.snakeproject.Model.SnakeModel;
import com.example.snakeproject.Views.SnakeView;
import com.example.snakeproject.Views.Theme;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for gameScene.fxml handles the creating the game loop and
 * holds instance of snake to be used.
 * */
public class GameController implements Initializable {

    public Button closeButton;
    @FXML
    AnchorPane gameScene;

    @FXML
    Canvas canvas;

    @FXML
    ImageView background;

    AnimationTimer timer;

    private GamemodeFactory gamemodeFactory = new GamemodeFactory();

    private SnakeModel snakeModel = new SnakeModel(100,100);

    // settings default Theme
    private Theme theme = new
            Theme("gameBackground0","snake1");
    private Gamemode gamemode;
    public SnakeModel getSnakeModel() {return snakeModel;}
    public SnakeView getSnakeView() {return theme.getSnakeView();}

    /**
     * reset game by creating new SnakeModel and reseting rotation of the
     * snake head Image in SnakeView
     * */
    public boolean resetGame(){
        this.snakeModel = new SnakeModel(100,100);
        getSnakeView().resetHead();
        return true;
    }

    /**
     * sets gamemode according to class variables in gameType
     *
     * @param gameType gametype to set to.
     * */
    public void setGameType(GameType gameType){
        gamemode = gamemodeFactory.getGamemode(theme,
                canvas.getGraphicsContext2D(),snakeModel,gameType);
    }

    /**
     * sets theme and background image.
     * @param theme theme to set to
     * */
    public void setTheme(Theme theme){
        this.theme = theme;
        background.setImage(theme.getBackground());
    }

    /**
     * stops game loop
     * */
    public void stopGame(){
        timer.stop();
    }

    /**
     * starts game loop by creating instance of animation timer ad calling
     * AnimationTimer.start();
     * */
    public void startGame() {

        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                gamemode.handle(l);
            }
        };
        timer.start();
    }

    /**
     * called by javafx when scene is loaded.
     * @param url FUNCTION NOT TO BE CALLED
     * @param resourceBundle FUNCTION NOT BE CALLED
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gamemode = new Gamemode(theme, canvas.getGraphicsContext2D(),
                snakeModel, GameType.Difficulty.easy);
        closeButton.setFocusTraversable(false);
        background.setImage(theme.getBackground());
    }
}
