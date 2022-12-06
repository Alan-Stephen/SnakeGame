package com.example.snakeproject.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable  {

    @FXML
    RadioButton background1,background2,background3,background4;
    @FXML
    RadioButton snake1,snake2,snake3;

    @FXML
    RadioButton gamemode1,gamemode2,gamemode3,gamemode4;

    @FXML
    public
    Button backButton;

    private String snakeSelected = "snake1";
    private String backgroundSelected = "gameBackground0";

    private String gamemodeSelected = "gamemode0";
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        snake1.setSelected(true);
        background1.setSelected(true);
    }

    @FXML
    public void getGamemode(ActionEvent e) {
        if(gamemode1.isSelected()){
            snakeSelected = "gamemode1";
        } else if (gamemode2.isSelected()) {
            snakeSelected = "gamemode2";
        } else if (gamemode3.isSelected()) {
            snakeSelected = "gamemode3";
        } else if (gamemode4.isSelected()) {
            gamemodeSelected = "gamemode4";
        }
    }

    @FXML
    public void getSnake(ActionEvent e){
        if(snake1.isSelected()){
            snakeSelected = "snake1";
        } else if (snake2.isSelected()) {
            snakeSelected = "snake2";
        } else if (snake3.isSelected()) {
            snakeSelected = "snake3";
        }
    }
    @FXML
    public void getBackground(ActionEvent actionEvent) {
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

    public String getBGPath(){
        return backgroundSelected;
    }

    public String getSnakeSelected(){return snakeSelected;}

    public String getGamemodeSelected(){return  gamemodeSelected;}
}
