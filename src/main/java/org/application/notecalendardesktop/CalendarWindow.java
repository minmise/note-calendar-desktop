package org.application.notecalendardesktop;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;

public class CalendarWindow {

    private final LocalDate today = LocalDate.now();
    private final int WEEK_SIZE = 7;
    private final int MONTH_SIZE = 6;

    public void build() {
        Stage stage = new Stage();
        stage.setTitle("Note Calendar");
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp, 1320, 940);
        stage.setScene(scene);
        GridPane gp_Calendar = new GridPane();
        bp.setCenter(gp_Calendar);
        for (int i = 0; i < MONTH_SIZE; ++i) {
            for (int j = 0; j < WEEK_SIZE; ++j) {
                Text text = new Text("Today is " +
                        today.getDayOfMonth() + "." +
                        today.getMonthValue() + "." +
                        today.getYear() + "!");
                gp_Calendar.add(text, i, j);
            }
        }
        stage.show();
    }

}
