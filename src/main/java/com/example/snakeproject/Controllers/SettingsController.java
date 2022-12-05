package com.example.snakeproject.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable  {

    @FXML
    RadioButton background1,background2,background3,background4;
    @FXML
    RadioButton snake1,snake2,snake3;
    @FXML
    public
    Button backButton;

    String snakeSelected = "snake1";
    String backgroundSelected = "gameBackground0";
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        background1.setSelected(true);
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
}
