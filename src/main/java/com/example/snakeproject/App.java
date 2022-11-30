package com.example.snakeproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.Key;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource("/gameScene.fxml"));

        Scene scene = new Scene(myLoader.load());
        GameController c = myLoader.getController();


        GameKeyListener gkl = new GameKeyListener(c.mySnake);
        scene.addEventHandler(KeyEvent.KEY_PRESSED,gkl);

        stage.setScene(scene);
        stage.show();
    }
}
