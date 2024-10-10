package org.application.notecalendardesktop;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public class MainWindow {

    private final BorderPane bp = new BorderPane();
    Stage stage = new Stage();

    public Stage getStage() {
        return stage;
    }

    public void build() {
        StackPane mainLayout = new StackPane(bp);
        Scene scene = new Scene(mainLayout, 1320, 940);
        stage.setTitle("Note Calendar");
        scene.getStylesheets().
                add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
        stage.setScene(scene);
        buildSideBar();
        buildCalendar();
        stage.show();
    }

    public void buildCalendar() {
        CalendarWindow calendarWindow = new CalendarWindow();
        calendarWindow.build(bp);
    }

    public void buildOrganizations() {
        OrganizationsWindow organizationsWindow = new OrganizationsWindow();
        organizationsWindow.build(this);
    }

    private void buildSideBar() {
        SideBar sideBar = new SideBar();
        sideBar.build(this);
    }

    public BorderPane getBp() {
        return bp;
    }

}
