package org.application.notecalendardesktop.userinterface;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.application.notecalendardesktop.client.Note;

public class NoteCreationWindow {

    private final Stage stage = new Stage();
    private final Label windowName = new Label("Create note");
    private final TextField nameField = new TextField();
    private final TextField descField = new TextField();
    private final HBox timeData = new HBox();
    private final CheckBox timeCheckBox = new CheckBox("Time");
    private final TextField textFieldHours = new TextField();
    private final TextField textFieldMinutes = new TextField();
    private final HBox hBoxInner = new HBox();
    private final HBox verifData = new HBox();

    private CalendarWindow calendarWindow = null;
    private int x = -1;
    private int y = -1;

    private Label getWindowName() {
        windowName.setStyle("-fx-font-size:18pt;");
        return windowName;
    }

    private TextField getEnterName() {
        nameField.setStyle("-fx-min-width: 500;" +
                "-fx-font-size: 18pt;");
        nameField.setPromptText("Enter note name");
        return nameField;
    }

    private TextField getEnterDescription() {
        descField.setStyle("-fx-min-width: 500;" +
                "-fx-min-height: 200;" +
                "-fx-font-size: 15pt;");
        descField.setPromptText("Enter description");
        return descField;
    }

    private HBox getTimeData() {
        timeCheckBox.setStyle("-fx-font-size: 15pt;");
        textFieldHours.setStyle("-fx-min-width: 50;" +
                "-fx-font-size: 15pt;");
        textFieldMinutes.setStyle("-fx-min-width: 50;" +
                "-fx-font-size: 15pt;");
        Label label = new Label(":");
        label.setStyle("-fx-min-width: 50;" +
                "-fx-font-size: 15pt;");
        hBoxInner.getChildren().add(textFieldHours);
        hBoxInner.getChildren().add(label);
        hBoxInner.getChildren().add(textFieldMinutes);
        hBoxInner.setStyle("-fx-padding: 20;" +
                "-fx-spacing: 20;");
        timeData.getChildren().add(timeCheckBox);
        timeData.getChildren().add(hBoxInner);
        timeData.setStyle("-fx-padding: 20;" +
                "-fx-spacing: 40;");
        return timeData;
    }

    /*private HBox getRegularData() {
        HBox hBox = new HBox();

        return hBox;
    }*/

    private HBox getVerification() {
        Button okButton = new Button("OK");
        okButton.setStyle("-fx-font-size: 20pt;" +
                "-fx-background-color: #90ee90;");
        okButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            stage.close();
            Note note = new Note();
            note.setName(nameField.getText());
            note.setDescription(descField.getText());
            note.setTimeIncluded(timeCheckBox.isSelected());
            if (timeCheckBox.isSelected()) {
                note.setHours(Integer.parseInt(textFieldHours.getText()));
                note.setMinutes(Integer.parseInt(textFieldMinutes.getText()));
            }
            calendarWindow.printNoteInfo(note, x, y);
        });
        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-font-size: 20pt;" +
                "-fx-background-color: #ffbebe;");
        cancelButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            stage.close();
        });
        verifData.getChildren().add(okButton);
        verifData.getChildren().add(cancelButton);
        verifData.setStyle("-fx-padding: 20;" +
                "-fx-spacing: 40;");
        return verifData;
    }

    public void build(MainWindow mainWindow, CalendarWindow calendarWindow, int x, int y) {
        this.x = x;
        this.y = y;
        this.calendarWindow = calendarWindow;
        stage.initOwner(mainWindow.getStage());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.TRANSPARENT);
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 900, 900);
        stage.setScene(scene);
        VBox vBox = new VBox();
        vBox.setStyle("-fx-padding: 20;" +
                "-fx-border-color: black;" +
                "-fx-spacing: 50;");
        vBox.getChildren().add(getWindowName());
        vBox.getChildren().add(getEnterName());
        vBox.getChildren().add(getEnterDescription());
        vBox.getChildren().add(getTimeData());
        //vBox.getChildren().add(getRegularData());
        vBox.getChildren().add(getVerification());
        layout.getChildren().add(vBox);
        stage.show();
    }

}
