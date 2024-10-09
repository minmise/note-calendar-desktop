package org.application.notecalendardesktop;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class CalendarWindow {

    private final LocalDate today = LocalDate.now();
    private final int WEEK_SIZE = 7;
    private final int MONTH_SIZE = 6;
    private final String[] DAYS_OF_WEEK = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    private final String[] MONTH_NAMES = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private final String[] MONTH_NAMES_FULL = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    private final Label leftPointerLabel = new Label("<");
    private final Label rightPointerLabel = new Label(">");
    private final Label curMonthLabel = new Label(MONTH_NAMES_FULL[today.getMonthValue() - 1] + ", " +
            today.getYear());

    public void build() {
        Stage stage = new Stage();
        stage.setTitle("Note Calendar");
        BorderPane bp = new BorderPane();
        Scene scene = new Scene(bp, 1320, 940);
        stage.setScene(scene);
        HBox hbTop = new HBox();
        hbTop.getChildren().add(curMonthLabel);
        HBox hbBottom = new HBox();
        hbBottom.getChildren().add(leftPointerLabel);
        hbBottom.getChildren().add(rightPointerLabel);
        GridPane gp_Calendar = new GridPane();
        bp.setTop(hbTop);
        bp.setCenter(gp_Calendar);
        bp.setBottom(hbBottom);
        for (int j = 0; j < WEEK_SIZE; ++j) {
            Label dayLabel = new Label(DAYS_OF_WEEK[j]);
            gp_Calendar.add(dayLabel, j, 0);
        }
        LocalDate startOfMonth = today.minusDays(today.getDayOfMonth() - 1);
        LocalDate curDay = startOfMonth.minusDays(startOfMonth.getDayOfWeek().getValue() - 1);
        for (int i = 1; i <= MONTH_SIZE; ++i) {
            for (int j = 0; j < WEEK_SIZE; ++j) {
                int dayOfMonth = curDay.getDayOfMonth();
                String labelText = String.valueOf(dayOfMonth);
                if (i == 1 && j == 0 || dayOfMonth == 1) {
                    labelText = MONTH_NAMES[curDay.getMonthValue() - 1] + ", " + labelText;
                }
                Label dateLabel = new Label(labelText);
                gp_Calendar.add(dateLabel, j, i);
                curDay = curDay.plusDays(1);
            }
        }
        stage.show();
    }

}
