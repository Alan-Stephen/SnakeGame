package com.example.snakeproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

// TODO: PRIVATE JAVAFX NODES AND SCENES VARIABLES FOR ALL CONTROLLERS
public class DeathController implements Initializable {

    @FXML
    AnchorPane deathScene;

    @FXML
    Button submitButton;

    @FXML
    TextField nameField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // submitButton.setOnAction( actionEvent -> {addToLeaderBoards();});
    }

    public String getName(){return nameField.getText();}

    public boolean addToLeaderBoards(int score){
        System.out.println("writing");
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(
                    new File("src/main/resources/images/leaderBoards.csv"),
                    true /* append = true */));
            System.out.printf("%s, %d\n",getName(),score);
            writer.printf("%s, %d\n",getName(),score);
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
