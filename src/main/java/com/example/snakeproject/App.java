package com.example.snakeproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

// TODO : make use of boolean statements
public class App extends Application {

    private boolean setUpDeath(Stage stage,GameController gc) throws IOException {

        FXMLLoader deathLoader = new FXMLLoader(getClass().getResource("/deathScene.fxml"));
        Scene deathScene = new Scene(deathLoader.load());
        gc.snakeAliveProperty().addListener( (observableValue, oldVal, newVal) -> {
            if(newVal){}
            else {
                stage.setScene(deathScene);
            }
        } );
        DeathController deathController = deathLoader.getController();
        deathController.submitButton.setOnAction(actionEvent -> {
            deathController.addToLeaderBoards(gc.getMySnake().score);
        });


        return true;
    }

    private boolean play(Stage stage, FXMLLoader loader) {
        try {
            Scene gameScene = new Scene(loader.load());
            GameController gameController = loader.getController();
            GameKeyListener gkl = new GameKeyListener(gameController.getMySnake());

            setUpDeath(stage,gameController);

            gameScene.addEventHandler(KeyEvent.KEY_PRESSED, gkl);

            System.out.println("settning scene");
            stage.setScene(gameScene);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader gameLoader = new FXMLLoader(getClass().getResource("/gameScene.fxml"));
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("/mainMenu.fxml"));

        GameController gameController = gameLoader.getController();

        Scene menuScene = new Scene(menuLoader.load());
        MenuController menuController = menuLoader.getController();
        menuController.playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(play(stage,gameLoader));
            }
        });


        stage.setScene(menuScene);

        stage.show();
    }
}
