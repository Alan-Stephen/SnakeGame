package com.example.snakeproject.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
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
    public
    Button submitButton;

    @FXML
    TextField nameField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // submitButton.setOnAction( actionEvent -> {addToLeaderBoards();});
        Pattern pattern = Pattern.compile("[a-zA-Z]*");
        UnaryOperator<TextFormatter.Change> filter = new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                if (pattern.matcher(change.getControlNewText()).matches()) {
                    return change ;
                } else {
                    return null ;
                }
            }
        };

        TextFormatter<String> formatter = new TextFormatter<>(filter);
        nameField.setTextFormatter(formatter);
    }

    public String getName(){return nameField.getText();}

    public void addToLeaderBoards(int score){
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(
                    new File("src/main/resources/other/leaderBoards.csv"),
                    true /* append = true */));
            System.out.printf("%s, %d\n",getName(),score);
            writer.printf("%s,%d\n",getName(),score);
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        nameField.clear();
    }
}
