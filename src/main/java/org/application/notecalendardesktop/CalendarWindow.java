package org.application.notecalendardesktop;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CalendarWindow {

    public void build() {
        Stage stage = new Stage();
        stage.setTitle("Note Calendar");
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp, 1320, 940);
        stage.setScene(scene);
        stage.show();
    }

}
