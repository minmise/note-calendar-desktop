package org.application.notecalendardesktop.userinterface;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
        VBox vBox = new VBox();
        TextField loginField = new TextField();
        loginField.setStyle("-fx-font-size: 15;");
        loginField.setPromptText("Login");
        loginField.setMaxWidth(500);
        PasswordField passwordField = new PasswordField();
        passwordField.setStyle("-fx-font-size: 15;");
        passwordField.setPromptText("Password");
        passwordField.setMaxWidth(500);
        Button signInButton = new Button("Sign in");
        signInButton.setStyle("-fx-min-width: 100;" +
                "-fx-min-height: 30;" +
                "-fx-background-color: #ffbebe;" +
                "-fx-font-size: 20pt;");
        Button signUpButton = new Button("Sign up");
        signUpButton.setStyle("-fx-min-width: 100;" +
                "-fx-min-height: 30;" +
                "-fx-background-color: #ffbebe;" +
                "-fx-font-size: 20pt;");
        vBox.getChildren().add(loginField);
        vBox.getChildren().add(passwordField);
        vBox.getChildren().add(signInButton);
        vBox.getChildren().add(signUpButton);
        vBox.setStyle("-fx-padding: 30;" +
                "-fx-spacing: 20;");
        vBox.setAlignment(Pos.CENTER);
        root.setCenter(vBox);
        signInButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buildMainWindow);
        signUpButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buildMainWindow);
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