package com.example.snakeproject;

import com.example.snakeproject.Controllers.*;
import com.example.snakeproject.Views.ImageUtil;
import com.example.snakeproject.Views.MusicPlayer;
import com.example.snakeproject.Views.Theme;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


/**
 * App class acts as entry point into the program also is subclass of
 * Application. it is the primary controller of the project. it assigns
 * buttons the role of switching scenes when pressed and transfers information
 * bewteen scenes.
 * */
public class App extends Application {

    Stage stage;

    FXMLLoader gameLoader,leaderBoardsLoader,deathLoader,menuLoader,
            settingsLoader;
    Scene gameScene, leaderBoardsScene, deathScene, menuScene,settingsScene;

    // Paths for audio
    String GAME_MUSIC_PATH = "src/main/resources/audio/gamemusic.mp3";
    String EAT_MUSIC_PATH = "src/main/resources/audio/eatSound.wav";
    String BOMB_MUSIC_PATH = "src/main/resources/audio/bombSound.wav";

    /** Sets up gameScene and deathScene, starts up the game and adds listener
     * to Properties to play appropiate sounds. handles snake death and deals
     * with scene switches during the course of the game.
     * */
    private void startGame(){
        GameController gameController = gameLoader.getController();
        DeathController deathController = deathLoader.getController();
        SettingsController settingsController = settingsLoader.getController();
        MusicPlayer gameMusic = new MusicPlayer(GAME_MUSIC_PATH);

        // start playing game music and loop it.
        gameMusic.play();
        gameMusic.loopMusic();

        // play EAT_MUSIC_PATH whenever score changes
        gameController.getSnakeModel().scoreProperty().
                addListener((v, oldVal, newVal) -> {
                    MusicPlayer.getMusicPlay(EAT_MUSIC_PATH);
                });

        // assigns a annoymous lambda function to activate whenever
        // activeProperty is set to false.
        gameController.getSnakeModel().activeProperty()
                .addListener( ((observableValue, oldVal, newVal) -> {
                    if (newVal){}
                    else{
                        // Stops music, plays BOMB_MUSIC_PATH, sets scene to
                        // death scene, passes score to deathController and
                        // stops game loop
                        gameMusic.stopMusic();
                        MusicPlayer.getMusicPlay(BOMB_MUSIC_PATH);
                        stage.setScene(deathController.deathScene.getScene());
                        deathController.setScore(gameController.
                                getSnakeModel().getScore());
                        gameController.stopGame();
                    }
                }));

        // assigns annoymous lamda function to closeButton which stops music,
        // switches scene to menuScene and stops game loop.
        gameController.closeButton.setOnAction(actionEvent -> {
            stage.setScene(menuScene);
            gameMusic.stopMusic();
            gameController.stopGame();
        });

        // passes theme to setTheme with parameters selected from
        // settingsController
        gameController.setTheme(new Theme(settingsController.getBGPath(),
                settingsController.getSnakeSelected()));

        // assign listener to gameScene to handle snakeMovement
        gameScene.addEventHandler(KeyEvent.KEY_PRESSED,
                new GameKeyListener(
                        gameController.getSnakeModel(),
                        gameController.getSnakeView()));

        // assigns annoymous lambda function to add score to leaderboards when
        // submitButton is pressed also sets scene to leaderBoardsScene.
        deathController.submitButton.setOnAction(actionEvent -> {
            deathController.addToLeaderBoards(gameController.getSnakeModel().getScore());
            ((LeaderBoardController) leaderBoardsLoader.getController())
                    .updateList();
            stage.setScene(leaderBoardsScene);
        });

        // passes gameType from settings to gameController and starts game.
        gameController.setGameType(settingsController.getGameType());
        gameController.startGame();
    }

    /**
     * Start function, called by javafx when launch() is called. to not be
     * called by anything other than javafx. handles switching scenes and
     * loading in fxml.
     *
     * @param stage primary stage of GUI which nodes and scenes are to be
     *              applied to
     * */
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setResizable(false);
        stage.getIcons().add(ImageUtil.getInstance().getImage("icon"));

        // get loaders for every Scene.
        gameLoader = new FXMLLoader(getClass().getResource("/fxml/gameScene.fxml"));
        menuLoader = new FXMLLoader(getClass().getResource("/fxml/mainMenu.fxml"));
        deathLoader = new FXMLLoader(getClass().getResource("/fxml/deathScene.fxml"));
        leaderBoardsLoader = new FXMLLoader(getClass().getResource("/fxml/leaderBoardsScene.fxml"));
        settingsLoader = new FXMLLoader(getClass().getResource("/fxml/settingsScene.fxml"));

        // makes application completely end on close, in case of loose music
        // threads
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
            System.out.println("ERROR : UNABLE TO LOAD SCENE(s)");
            e.printStackTrace();
        }

        // Get Controllers for Settings,menu,leaderboard scene so their nodes
        // can be accessed.
        SettingsController settingsController = settingsLoader.getController();
        MenuController menuController = menuLoader.getController();
        LeaderBoardController leaderBoardController = leaderBoardsLoader.getController();

        // sets actionEvent to backButton so it will bring it back to menuScene
        settingsController.backButton.setOnAction(actionEvent -> {
            stage.setScene(menuScene);
        });

        // playButton calls startGame()
        menuController.playButton.setOnAction( actionEvent -> {startGame();});


        // settingsButton sets scene to settingsScene
        menuController.settingsButton.setOnAction(
                actionEvent -> {stage.setScene(settingsScene);}
        );

        // leaderBoardsButton sets Scene to leaderBoards and refreshes
        // its table.
        menuController.leaderboardButton.setOnAction( actionEvent -> {
            leaderBoardController.updateList();
            stage.setScene(leaderBoardsScene);
        });

        // backButton in leader will setScene to menuScene
        leaderBoardController.backButton.setOnAction( actionEvent -> {
            stage.setScene(menuScene);
        });

        // play buttton will switch scene to gameScene and reset the game.
        menuController.playButton.setOnAction(actionEvent -> {
            GameController gameController = gameLoader.getController();
            gameController.resetGame();
            startGame();
            stage.setScene(gameScene);
        });

        // application will initially start on menuScene
        stage.setScene(menuScene);

        stage.show();
    }


    /**
     * Main function, includes launch(args) which starts javafx application
     * */
    public static void main(String[] args) {
        launch(args);
    }
}
