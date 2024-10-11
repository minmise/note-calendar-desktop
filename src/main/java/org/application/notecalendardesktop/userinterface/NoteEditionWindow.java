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

public class NoteEditionWindow {

    private final Stage stage = new Stage();
    private final Label windowName = new Label("Note");
    private final TextField nameField = new TextField();
    private final TextField descField = new TextField();
    private final HBox timeData = new HBox();
    private final CheckBox timeCheckBox = new CheckBox("Time");
    private final TextField textFieldHours = new TextField();
    private final TextField textFieldMinutes = new TextField();
    private final HBox hBoxInner = new HBox();
    private final HBox verifData = new HBox();

    private Note note = null;
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
        nameField.setText(note.getName());
        return nameField;
    }

    private TextField getEnterDescription() {
        descField.setStyle("-fx-min-width: 500;" +
                "-fx-min-height: 200;" +
                "-fx-font-size: 15pt;");
        descField.setPromptText("Enter description");
        descField.setText(note.getDescription());
        return descField;
    }

    private HBox getTimeData() {
        timeCheckBox.setStyle("-fx-font-size: 15pt;");
        timeCheckBox.setSelected(note.isTimeIncluded());
        textFieldHours.setStyle("-fx-min-width: 50;" +
                "-fx-font-size: 15pt;");
        textFieldHours.setText(String.valueOf(note.getHours()));
        textFieldMinutes.setStyle("-fx-min-width: 50;" +
                "-fx-font-size: 15pt;");
        textFieldMinutes.setText(String.valueOf(note.getMinutes()));
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
        Button editButton = new Button("Edit");
        editButton.setStyle("-fx-font-size: 20pt;" +
                "-fx-background-color: #90ee90;");
        editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            stage.close();
            note.setName(nameField.getText());
            note.setDescription(descField.getText());
            note.setTimeIncluded(timeCheckBox.isSelected());
            if (timeCheckBox.isSelected()) {
                note.setHours(Integer.parseInt(textFieldHours.getText()));
                note.setMinutes(Integer.parseInt(textFieldMinutes.getText()));
            }
            calendarWindow.updateNotesEdit(note, x, y);
        });
        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-font-size: 20pt;" +
                "-fx-background-color: #ffbebe;");
        deleteButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            stage.close();
            calendarWindow.updateNotesDelete(note, x, y);
        });
        Button cancelButton = new Button("Cancel");
        cancelButton.setStyle("-fx-font-size: 20pt;" +
                "-fx-background-color: #ffbebe;");
        cancelButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            stage.close();
        });
        verifData.getChildren().add(editButton);
        verifData.getChildren().add(deleteButton);
        verifData.getChildren().add(cancelButton);
        verifData.setStyle("-fx-padding: 20;" +
                "-fx-spacing: 40;");
        return verifData;
    }

    public void build(MainWindow mainWindow, CalendarWindow calendarWindow, Note note, int x, int y) {
        this.x = x;
        this.y = y;
        this.calendarWindow = calendarWindow;
        this.note = note;
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
