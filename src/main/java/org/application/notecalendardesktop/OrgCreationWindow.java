package org.application.notecalendardesktop;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OrgCreationWindow {

    private final Stage stage = new Stage();

    private Label getWindowName() {
        Label windowName = new Label("Create organization");
        windowName.setStyle("-fx-font-size:18pt;");
        return windowName;
    }

    private TextField getEnterName() {
        TextField textField = new TextField();
        textField.setStyle("-fx-min-width: 500;" +
                "-fx-font-size: 18pt;");
        textField.setPromptText("Enter organization name");
        return textField;
    }

    private TextField getEnterDescription() {
        TextField textField = new TextField();
        textField.setStyle("-fx-min-width: 500;" +
                "-fx-min-height: 200;" +
                "-fx-font-size: 15pt;");
        textField.setPromptText("Enter description");
        return textField;
    }

    private HBox getVerification() {
        HBox hBox = new HBox();
        Button okButton = new Button("OK");
        okButton.setStyle("-fx-font-size: 20pt;" +
                "-fx-background-color: #90ee90;");
        okButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            stage.close();
        });
        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-font-size: 20pt;" +
                "-fx-background-color: #ffbebe;");
        cancelButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            stage.close();
        });
        hBox.getChildren().add(okButton);
        hBox.getChildren().add(cancelButton);
        hBox.setStyle("-fx-padding: 20;" +
                "-fx-spacing: 40;" +
                "-fx-alignment: right;");
        return hBox;
    }

    public void build(MainWindow mainWindow) {
        stage.initOwner(mainWindow.getStage());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.TRANSPARENT);
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 600, 600);
        stage.setScene(scene);
        VBox vBox = new VBox();
        vBox.setStyle("-fx-padding: 20;" +
                "-fx-border-color: black;" +
                "-fx-spacing: 50;");
        vBox.getChildren().add(getWindowName());
        vBox.getChildren().add(getEnterName());
        vBox.getChildren().add(getEnterDescription());
        vBox.getChildren().add(getVerification());
        layout.getChildren().add(vBox);
        stage.show();
    }

}
