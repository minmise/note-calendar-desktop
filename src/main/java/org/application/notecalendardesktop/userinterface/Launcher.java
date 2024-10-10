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
import org.application.notecalendardesktop.client.User;
import org.application.notecalendardesktop.client.UserHandler;

public class Launcher extends Application {

    private Stage stageSaver;
    private final TextField loginField = new TextField();
    private final PasswordField passwordField = new PasswordField();

    @Override
    public void start(Stage stage) {
        stageSaver = stage;
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1320, 940);
        stage.setTitle("Note Calendar Authorization");
        stage.setScene(scene);
        VBox vBox = new VBox();
        loginField.setStyle("-fx-font-size: 15;");
        loginField.setPromptText("Login");
        loginField.setMaxWidth(500);
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
        signInButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::openApplication);
        signUpButton.addEventHandler(MouseEvent.MOUSE_CLICKED, this::openApplication);
        stage.show();
    }

    private void openApplication(MouseEvent mouseEvent) {
        UserHandler.setCurrentUser(new User(loginField.getText(), 0));
        buildMainWindow();
        closeStage();
    }

    private void buildMainWindow() {
        MainWindow window = new MainWindow();
        window.build();
    }

    private void closeStage() {
        stageSaver.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}