package org.application.notecalendardesktop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Launcher extends Application {
    private Stage stageSaver;

    @Override
    public void start(Stage stage) {
        stageSaver = stage;
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1320, 940);
        stage.setTitle("Note Calendar Authorization");
        stage.setScene(scene);
        Button startButton = new Button("sign in");
        root.setCenter(startButton);
        startButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buildMainWindow);
        stage.show();
    }

    private void buildMainWindow(MouseEvent mouseEvent) {
        MainWindow window = new MainWindow();
        window.build();
        closeStage();
    }

    private void closeStage() {
        stageSaver.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}