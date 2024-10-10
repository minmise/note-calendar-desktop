package org.application.notecalendardesktop;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class CalendarWindow {

    private static final int WEEK_SIZE = 7;
    private static final int MONTH_SIZE = 6;
    private static final String[] DAYS_OF_WEEK = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    private static final String[] MONTH_NAMES = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String[] MONTH_NAMES_FULL = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    private final BorderPane bp = new BorderPane();
    private final Label leftPointerLabel = new Label("<");
    private final Label rightPointerLabel = new Label(">");

    private LocalDate monthIterator = LocalDate.now().minusDays(LocalDate.now().getDayOfMonth() - 1);

    private Label getMonthLabel() {
        return new Label(MONTH_NAMES_FULL[monthIterator.getMonthValue() - 1] + ", " + monthIterator.getYear());
    }

    private void rebuildCalendarByMonth() {
        GridPane gp_Calendar = new GridPane();
        HBox hbTop = new HBox();
        HBox hbBottom = new HBox();

        hbTop.getChildren().add(getMonthLabel());
        hbBottom.getChildren().add(leftPointerLabel);
        hbBottom.getChildren().add(rightPointerLabel);
        bp.setTop(hbTop);
        bp.setCenter(gp_Calendar);
        bp.setBottom(hbBottom);

        for (int j = 0; j < WEEK_SIZE; ++j) {
            Label dayLabel = new Label(DAYS_OF_WEEK[j]);
            gp_Calendar.add(dayLabel, j, 0);
        }

        LocalDate curDay = monthIterator.minusDays(monthIterator.getDayOfWeek().getValue() - 1);
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
    }

    public void build() {
        Stage stage = new Stage();
        Scene scene = new Scene(bp, 1320, 940);
        stage.setTitle("Note Calendar");
        stage.setScene(scene);
        rebuildCalendarByMonth();
        leftPointerLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            bp.getChildren().clear();
            monthIterator = monthIterator.minusMonths(1);
            rebuildCalendarByMonth();
        });
        rightPointerLabel.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            bp.getChildren().clear();
            monthIterator = monthIterator.plusMonths(1);
            rebuildCalendarByMonth();
        });
        stage.show();
    }

}
