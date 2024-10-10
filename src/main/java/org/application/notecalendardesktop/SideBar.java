package org.application.notecalendardesktop;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class SideBar {

    private final VBox boxData = new VBox();
    private final Button calendarButton = new Button("Calendar");

    public void build(MainWindow window) {
        BorderPane bp = window.getBp();
        calendarButton.setStyle("-fx-min-width: 100;" +
                "-fx-min-height: 30;" +
                "-fx-background-color: #ffbebe;" +
                "-fx-font-size: 20pt;");
        calendarButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> window.buildCalendar());
        boxData.getChildren().add(calendarButton);
        bp.setLeft(boxData);
    }

}
