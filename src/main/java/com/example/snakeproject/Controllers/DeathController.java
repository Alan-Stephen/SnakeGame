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


/**
 * Controller for deathScene.fxml used to access player name from text field
 * and adding a score to leaderboards.csv, allows access of deathScene nodes.
 * */
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

    public String getName(){return nameField.getText();}


    /**
     * called by javafx when scene is loaded, applies a TextFormater to
     * nameField to only allow alphabetical characters to be entered.
     * */
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

    /**
     * adds player name and score to leaderboards.csv and resets nameField.
     *
     * @param score score of player to add to leaderboards.
     * */
    public void addToLeaderBoards(int score){
        if(getName().isEmpty()){
            return;
        }
        try {

            PrintWriter writer = new PrintWriter(new FileOutputStream(
                    LEADERBOARDS_PATH,
                    true));

            writer.printf("%s,%d\n",getName(),score);
            writer.close();
        } catch (Exception e){
            System.out.println("ERROR : FILE NOT FOUND " + LEADERBOARDS_PATH);
            e.printStackTrace();
        }
        nameField.clear();
    }

    /**
     * sets text of scoreLabel to score
     *
     * @param score score to set to
     * */
    public void setScore(int score){
        scoreLabel.setText(Integer.toString(score));
    }
}
