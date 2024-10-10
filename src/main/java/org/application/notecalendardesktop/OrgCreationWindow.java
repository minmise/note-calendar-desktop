package org.application.notecalendardesktop;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class OrgCreationWindow {

    public void build(MainWindow mainWindow) {
        Stage stage = new Stage();
        stage.initOwner(mainWindow.getStage());
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.TRANSPARENT);
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        VBox noteLayout = new VBox();
        noteLayout.setStyle("-fx-padding: 10px;");
        Label noteLabel = new Label("Create organization");
        noteLayout.getChildren().add(noteLabel);
        layout.getChildren().add(noteLayout);
        stage.show();
    }

}
