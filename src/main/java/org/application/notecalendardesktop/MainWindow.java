package org.application.notecalendardesktop;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Objects;

public class MainWindow {

    private final BorderPane bp = new BorderPane();

    public void build() {
        Stage stage = new Stage();
        Scene scene = new Scene(bp, 1320, 940);
        stage.setTitle("Note Calendar");
        scene.getStylesheets().
                add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
        stage.setScene(scene);
        buildCalendar();
        buildSideBar();
        stage.show();
    }

    public void buildCalendar() {
        CalendarWindow calendarWindow = new CalendarWindow();
        calendarWindow.build(bp);
    }

    private void buildSideBar() {
        SideBar sideBar = new SideBar();
        sideBar.build(this);
    }

    public BorderPane getBp() {
        return bp;
    }

}
