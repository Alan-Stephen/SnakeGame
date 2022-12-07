package com.example.snakeproject.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class DeathController implements Initializable {

    @FXML
    public
    AnchorPane deathScene;

    @FXML
    Label scoreLabel;
    @FXML
    public
    Button submitButton;

    @FXML
    TextField nameField;

    private final String LEADERBOARDS_PATH =
            "src/main/resources/other/leaderBoards.csv";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pattern pattern = Pattern.compile("[a-zA-Z]*");
        UnaryOperator<TextFormatter.Change> filter = change -> {
            if (pattern.matcher(change.getControlNewText()).matches()) {
                return change ;
            } else {
                return null ;
            }
        };

        TextFormatter<String> formatter = new TextFormatter<>(filter);
        nameField.setTextFormatter(formatter);
    }

    public String getName(){return nameField.getText();}

    public void addToLeaderBoards(int score){
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(
                    LEADERBOARDS_PATH,
                    true));

            if(getName() == ""){
                return;
            }
            writer.printf("%s,%d\n",getName(),score);
            writer.close();
        } catch (Exception e){
            System.out.println("ERROR : FILE NOT FOUND " + LEADERBOARDS_PATH);
            e.printStackTrace();
        }
        nameField.clear();
    }

    public void setScore(int score){
        scoreLabel.setText(Integer.toString(score));
    }
}
