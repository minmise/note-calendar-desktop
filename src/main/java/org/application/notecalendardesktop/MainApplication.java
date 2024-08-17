package org.application.notecalendardesktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sign-in-view.fxml"));
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1320, 940);
        stage.setTitle("Note Calendar");
        stage.setScene(scene);
        Button startButton = new Button("sign in");
        root.setCenter(startButton);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}