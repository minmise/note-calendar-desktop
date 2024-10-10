package org.application.notecalendardesktop.userinterface;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OrganizationsWindow {

    private final Label yourOrgLabel = new Label("Your Organizations");
    private final Button newOrgButton = new Button("+");
    private final HBox hBox = new HBox();
    private final VBox vBoxLeft = new VBox();
    private final VBox vBoxRight = new VBox();
    private final HBox yourOrgBox = new HBox();
    private final TextField searchField = new TextField();

    private MainWindow mainWindow = null;

    public void build(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        BorderPane bp = mainWindow.getBp();
        HBox hbTop = new HBox();
        HBox hbBottom = new HBox();
        hbTop.getStyleClass().add("hbtop");
        hbBottom.getStyleClass().add("hbbottom");
        bp.setTop(hbTop);
        bp.setBottom(hbBottom);
        buildLeft();
        buildRight();
        hBox.setStyle("-fx-spacing: 400;" +
                "-fx-padding: 10;" +
                "-fx-background-color: #f0f0f0;" +
                "-fx-alignment: center;");
        hBox.getChildren().add(vBoxLeft);
        hBox.getChildren().add(vBoxRight);
        bp.setCenter(hBox);
    }

    private void buildLeft() {
        searchField.setStyle("-fx-min-width: 600;" +
                "-fx-font-size: 20pt;");
        searchField.setPromptText("Enter id of organization you want to join");
        searchField.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
            }
        });
        vBoxLeft.getChildren().add(searchField);
    }

    private void buildRight() {
        yourOrgLabel.setStyle("-fx-padding: 10;" +
                "-fx-background-color: #ffbebe;" +
                "-fx-font-size: 20pt;");
        newOrgButton.setStyle("-fx-padding: 10;" +
                "-fx-background-color: #ffbebe;" +
                "-fx-font-size: 20pt;");
        newOrgButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            OrgCreationWindow orgCreationWindow = new OrgCreationWindow();
            orgCreationWindow.build(mainWindow);
        });
        yourOrgBox.setStyle("-fx-padding: 10;" +
                "-fx-spacing: 100;" +
                "-fx-alignment: center;");
        yourOrgBox.getChildren().add(yourOrgLabel);
        yourOrgBox.getChildren().add(newOrgButton);
        vBoxRight.getChildren().add(yourOrgBox);
    }

}
