package com.example.snakeproject;

import com.example.snakeproject.Controllers.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

// TODO : make use of boolean statements
public class App extends Application {

    Stage stage;

    FXMLLoader gameLoader,leaderBoardsLoader,deathLoader,menuLoader,
            settingsLoader;
    Scene gameScene, leaderBoardsScene, deathScene, menuScene,settingsScene;

    String GAME_MUSIC_PATH = "src/main/resources/audio/gamemusic.mp3";
    String EAT_MUSIC_PATH = "src/main/resources/audio/eatSound.wav";
    String BOMB_MUSIC_PATH = "src/main/resources/audio/bombSound.wav";

    private void startGame(){
        GameController gameController = gameLoader.getController();
        DeathController deathController = deathLoader.getController();
        SettingsController settingsController = settingsLoader.getController();
        MusicPlayer gameMusic = new MusicPlayer(GAME_MUSIC_PATH);
        gameMusic.play();
        gameMusic.loopMusic();

        gameController.getSnakeModel().scoreProperty().
                addListener((v, oldVal, newVal) -> {
                    MusicPlayer.getMusicPlay(EAT_MUSIC_PATH);
                });

        gameController.getSnakeModel().activeProperty()
                .addListener( ((observableValue, oldVal, newVal) -> {
                    if (newVal){}
                    else{
                        gameMusic.stopMusic();
                        MusicPlayer.getMusicPlay(BOMB_MUSIC_PATH);
                        stage.setScene(deathController.deathScene.getScene());
                        gameController.stopGame();
                    }
                }));

        gameController.closeButton.setOnAction(actionEvent -> {
            stage.setScene(menuScene);
            gameMusic.stopMusic();
            gameController.stopGame();
        });

        gameController.setTheme(new Theme(settingsController.getBGPath(),
                settingsController.getSnakeSelected()));

        gameScene.addEventHandler(KeyEvent.KEY_PRESSED,
                new GameKeyListener(
                        gameController.getSnakeModel(),
                        gameController.getSnakeView()));

        deathController.submitButton.setOnAction(actionEvent -> {
            deathController.addToLeaderBoards(gameController.getSnakeModel().getScore());
            ((LeaderBoardController) leaderBoardsLoader.getController())
                    .updateList();
            stage.setScene(leaderBoardsScene);
        });

        gameController.setGamemode(settingsController.getGamemodeSelected());
        gameController.startGame();
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setResizable(false);
        gameLoader = new FXMLLoader(getClass().getResource("/fxml/gameScene.fxml"));
        menuLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
        deathLoader = new FXMLLoader(getClass().getResource("/fxml/deathScene.fxml"));
        leaderBoardsLoader = new FXMLLoader(getClass().getResource("/fxml/leaderBoardsScene.fxml"));
        settingsLoader = new FXMLLoader(getClass().getResource("/fxml/settingsScene.fxml"));

        stage.setOnCloseRequest(windowEvent -> {
            System.exit(0);
        });

        // Load Scenes so Controllers can be accessed
        try{
            gameScene = new Scene(gameLoader.load());
            menuScene = new Scene(menuLoader.load());
            deathScene = new Scene(deathLoader.load());
            leaderBoardsScene = new Scene(leaderBoardsLoader.load());
            settingsScene = new Scene(settingsLoader.load());
        }catch (Exception e){
            e.printStackTrace();
        }

        SettingsController settingsController = settingsLoader.getController();
        MenuController menuController = menuLoader.getController();
        LeaderBoardController leaderBoardController = leaderBoardsLoader.getController();

        settingsController.backButton.setOnAction(actionEvent -> {
            stage.setScene(menuScene);
        });
        menuController.playButton.setOnAction( actionEvent -> {startGame();});

        menuController.settingsButton.setOnAction(
                actionEvent -> {stage.setScene(settingsScene);}
        );

        menuController.leaderboardButton.setOnAction( actionEvent -> {
            leaderBoardController.updateList();
            stage.setScene(leaderBoardsScene);
        });

        leaderBoardController.backButton.setOnAction( actionEvent -> {
            stage.setScene(menuScene);
        });

        menuController.playButton.setOnAction(actionEvent -> {
            if(gameScene == null) {
            }else {
                GameController gameController = gameLoader.getController();
                gameController.resetGame();
            }
            startGame();
            stage.setScene(gameScene);
        });

        stage.setScene(menuScene);

        stage.show();
    }
}
