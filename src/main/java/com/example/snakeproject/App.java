package com.example.snakeproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

// TODO : make use of boolean statements
public class App extends Application {

    Stage stage;

    FXMLLoader gameLoader,leaderBoardsLoader,deathLoader,menuLoader;
    Scene gameScene, leaderBoardsScene, deathScene, menuScene;

    private boolean startGame(){
        GameController gameController = gameLoader.getController();
        DeathController deathController = deathLoader.getController();

        gameController.getSnakeModel().activeProperty()
                .addListener( ((observableValue, oldVal, newVal) -> {
                    if (newVal){}
                    else{stage.setScene(deathController.deathScene.getScene());}
        }));

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED,
                new GameKeyListener(
                        gameController.getSnakeModel(),
                        gameController.getSnakeView()));

        deathController.submitButton.setOnAction(actionEvent -> {
            deathController.addToLeaderBoards(gameController.getSnakeModel().score);
            ((LeaderBoardController) leaderBoardsLoader.getController())
                    .updateList();
            stage.setScene(leaderBoardsScene);
        });

        return  true;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setResizable(false);

        gameLoader = new FXMLLoader(getClass().getResource("/fxml/gameScene.fxml"));
        menuLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
        deathLoader = new FXMLLoader(getClass().getResource("/fxml/deathScene.fxml"));
        leaderBoardsLoader = new FXMLLoader(getClass().getResource("/fxml/leaderBoardsScene.fxml"));

        // Load Scenes so Controllers can be accessed
        try{
            menuScene = new Scene(menuLoader.load());
            deathScene = new Scene(deathLoader.load());
            leaderBoardsScene = new Scene(leaderBoardsLoader.load());
        }catch (Exception e){
            e.printStackTrace();
        }

        MenuController menuController = menuLoader.getController();
        LeaderBoardController leaderBoardController = leaderBoardsLoader.getController();

        menuController.playButton.setOnAction( actionEvent -> {startGame();});

        menuController.leaderboardButton.setOnAction( actionEvent -> {
            leaderBoardController.updateList();
            stage.setScene(leaderBoardsScene);
        });

        leaderBoardController.backButton.setOnAction( actionEvent -> {
            stage.setScene(menuScene);
        });

        menuController.playButton.setOnAction(actionEvent -> {
            if(gameScene == null) {
                try {
                    gameScene = new Scene(gameLoader.load());
                    startGame();
                    stage.setScene(gameScene);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
                //startGame();
                GameController gameController = gameLoader.getController();
                gameController.resetGame();
                startGame();
                stage.setScene(gameScene);
            }
        });

        stage.setScene(menuScene);

        stage.show();
    }
}
