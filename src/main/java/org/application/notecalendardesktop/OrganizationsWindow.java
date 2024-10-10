package org.application.notecalendardesktop;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class OrganizationsWindow {

    private final Label emptyLabel = new Label("empty");

    public void build(BorderPane bp) {
        HBox hbTop = new HBox();
        HBox hbBottom = new HBox();
        hbTop.getStyleClass().add("hbtop");
        hbBottom.getStyleClass().add("hbbottom");
        bp.setTop(hbTop);
        bp.setBottom(hbBottom);
        bp.setCenter(emptyLabel);
    }

}
