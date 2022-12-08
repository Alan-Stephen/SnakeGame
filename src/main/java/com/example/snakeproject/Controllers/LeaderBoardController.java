package com.example.snakeproject.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * controller for leaderboard.fxml, generates leaderboard table from
 * leaderboard.csv
 * */
public class LeaderBoardController implements Initializable {

    public String CSV_PATH = "src/main/resources/other/leaderBoards.csv";

    @FXML
    TableView<LeaderBoardEntry> leaderBoardsTable;

    @FXML
    TableColumn<LeaderBoardEntry,String> name;

    @FXML
    TableColumn<LeaderBoardEntry, Integer> score;

    @FXML
    public
    Button backButton;

    ObservableList<LeaderBoardEntry> list = FXCollections.observableArrayList();



    /**
     * updates leaderboard table with updated information from leaderboards.csv
     * */
    public void updateList() {
        File file = new File(CSV_PATH);
        list.clear();
        try {
            Scanner in = new Scanner(file);
            while(in.hasNext()){
                String entry[] = in.next().split(",");
                list.add(new LeaderBoardEntry(entry[0], Integer.parseInt(entry[1]),0));
                FXCollections.sort(list, Comparator.comparingInt(LeaderBoardEntry::getScore));
                FXCollections.reverse(list);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: CANNOT UPDATE LEADERBOARD");
            throw new RuntimeException(e);
        }
    }

    /**
     * Called when leaderboards.fxml is loaded which is launched, sets
     * leaderboardsTable to track list, meaning additions to least will be
     * reflected in the table. also refreshed list with information from
     * leaderboards.csv by calling updateList
     * */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setCellValueFactory(
                new PropertyValueFactory<LeaderBoardEntry,String>("name"));
        score.setCellValueFactory(
                new PropertyValueFactory<LeaderBoardEntry,Integer>("score"));
        leaderBoardsTable.setItems(list);
        updateList();
    }
}
