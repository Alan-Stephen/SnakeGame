package com.example.snakeproject.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * acts as controller class for settings.fxml, has variables to hold the current
 * gamemode, difficulty and theme which are updated when radio buttons are
 * pressed, using getter functions will return the settings last updated by
 * the player. allows access of settingsScene nodes
 * */
public class SettingsController implements Initializable  {

    @FXML
    RadioButton background1,background2,background3,background4;
    @FXML
    RadioButton snake1,snake2,snake3;

    @FXML
    RadioButton gamemode1,gamemode2,gamemode3,gamemode4;
    @FXML
    RadioButton difficulty1;
    @FXML
    RadioButton difficulty2;
    @FXML
    RadioButton difficulty3;
    @FXML
    public
    Button backButton;

    private String snakeSelected = "snake1";
    private String backgroundSelected = "gameBackground0";

    private GameType.GameOption gamemodeSelected= GameType.GameOption.normal;
    private GameType.Difficulty difficultySelected = GameType.Difficulty.easy;


    /**
     * */
    public String getBGPath(){
        return backgroundSelected;
    }
    /**
     * @return return snake theme player has selected as a string, the string
     * through Theme will allow access of the correct image.
     * */
    public String getSnakeSelected(){return snakeSelected;}

    /**
     * @return returns an instance of gameType by using gamemodeSelected by
     * player and difficultySelected by player.
     * */
    public GameType getGameType(){
        return new GameType(gamemodeSelected, difficultySelected);
    }

    /**
     * if radioButton is pressed, functions find which gamemode was selected
     * and updated gamemodeSelected appropriately.
     * */
    @FXML
    public void setGamemode(ActionEvent e) {
        if(gamemode1.isSelected()){
            gamemodeSelected = GameType.GameOption.immortal;
        } else if (gamemode2.isSelected()) {
            gamemodeSelected = GameType.GameOption.feast;
        } else if (gamemode3.isSelected()) {
            gamemodeSelected = GameType.GameOption.deadlyFood;
        } else if (gamemode4.isSelected()) {
            gamemodeSelected = GameType.GameOption.normal;
        }
    }

    /**
     * if radio button is pressed then method finds which radio buttons is
     * pressed and sets difficultySelected appropriately.
     * */
    @FXML
    public void setDifficultySelected(ActionEvent e) {
        if(difficulty1.isSelected()){
            difficultySelected = GameType.Difficulty.easy;
        } else if (difficulty2.isSelected()) {
            difficultySelected = GameType.Difficulty.medium;
        } else if (difficulty3.isSelected()) {
            difficultySelected = GameType.Difficulty.hard;
        }
    }

    /**
     * if radio button is pressed then method finds which radio buttons is
     * pressed and sets snakeSelected appropriately.
     * */
    @FXML
    public void setSnake(ActionEvent e){
        if(snake1.isSelected()){
            snakeSelected = "snake1";
        } else if (snake2.isSelected()) {
            snakeSelected = "snake2";
        } else if (snake3.isSelected()) {
            snakeSelected = "snake3";
        }
    }

    /**
     * if radio button is pressed then method finds which radio buttons is
     * pressed and sets backgroundSelected appropriately.
     * */
    @FXML
    public void setBackground(ActionEvent actionEvent) {
        if(background1.isSelected()){
            backgroundSelected = "gameBackground0";
        } else if (background2.isSelected()) {
            backgroundSelected = "gameBackground1";
        } else if (background3.isSelected()) {
            backgroundSelected = "gameBackground2";
        } else if (background4.isSelected()) {
            backgroundSelected = "gameBackground3";
        }
    }

    /**
     * Called when settingsScene.fxml is called. sets radio buttons repersenting
     * default options to be selected.
     *
     * @param url irrelevant
     * @param resourceBundle irrelevant
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        difficulty1.setSelected(true);
        snake1.setSelected(true);
        background1.setSelected(true);
        gamemode4.setSelected(true);
    }

}
