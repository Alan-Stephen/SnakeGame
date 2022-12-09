module com.example.snakeproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jlayer;
    requires javafx.media;

    opens com.example.snakeproject to javafx.fxml;
    exports com.example.snakeproject;
    exports com.example.snakeproject.Controllers;
    opens com.example.snakeproject.Controllers to javafx.fxml;
    exports com.example.snakeproject.Views;
    opens com.example.snakeproject.Views to javafx.fxml;
    exports com.example.snakeproject.Model;
    opens com.example.snakeproject.Model to javafx.fxml;
}