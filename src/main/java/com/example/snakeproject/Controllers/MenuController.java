package com.example.snakeproject.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * controller class for menu, allows access of menu nodes.
 * */
public class MenuController implements Initializable {
    @FXML
    AnchorPane menu;

    @FXML
    public
    Button playButton;

    @FXML
    public
    Button leaderboardButton;

    @FXML
    public
    Button settingsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
    }


}

