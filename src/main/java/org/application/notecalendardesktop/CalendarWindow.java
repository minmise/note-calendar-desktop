package org.application.notecalendardesktop;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;

public class CalendarWindow {

    private final LocalDate today = LocalDate.now();

    public void build() {
        Stage stage = new Stage();
        stage.setTitle("Note Calendar");
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp, 1320, 940);
        stage.setScene(scene);
        Text text = new Text("Today is " +
                today.getDayOfMonth() + "." +
                today.getMonthValue() + "." +
                today.getYear() + "!");
        bp.setCenter(text);
        stage.show();
    }

}
