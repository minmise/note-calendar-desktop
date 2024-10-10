package org.application.notecalendardesktop.userinterface;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.application.notecalendardesktop.client.UserHandler;

public class SideBar {

    private final VBox boxData = new VBox();
    private final Button calendarButton = new Button("Calendar");
    private final Button organizationsButton = new Button("Organizations");
    private final Label loginLabel = new Label("User: " + UserHandler.getCurrentUser().getLogin());

    public void build(MainWindow window) {
        BorderPane bp = window.getBp();
        calendarButton.setStyle("-fx-min-width: 100;" +
                "-fx-min-height: 30;" +
                "-fx-background-color: #ffbebe;" +
                "-fx-font-size: 20pt;");
        calendarButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> window.buildCalendar());
        boxData.getChildren().add(calendarButton);
        organizationsButton.setStyle("-fx-min-width: 100;" +
                "-fx-min-height: 30;" +
                "-fx-background-color: #ffbebe;" +
                "-fx-font-size: 20pt;");
        organizationsButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> window.buildOrganizations());
        boxData.setStyle("-fx-padding: 10;" +
                "-fx-spacing: 100;" +
                "-fx-alignment: center;");
        boxData.getChildren().add(organizationsButton);
        loginLabel.setStyle("-fx-min-width: 100;" +
                "-fx-min-height: 30;" +
                "-fx-background-color: #f0f0f0;" +
                "-fx-font-size: 15pt;");
        boxData.getChildren().add(loginLabel);
        bp.setLeft(boxData);
    }

}
