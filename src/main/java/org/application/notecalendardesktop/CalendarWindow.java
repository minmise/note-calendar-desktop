package org.application.notecalendardesktop;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarWindow {

    private static final int WEEK_SIZE = 7;
    private static final int MONTH_SIZE = 6;
    private static final String[] DAYS_OF_WEEK = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    private static final String[] MONTH_NAMES_FULL = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    private final Button leftPointerButton = new Button("<");
    private final Button rightPointerButton = new Button(">");
    private final ArrayList<ArrayList<VBox>> vBoxList = new ArrayList<>();

    private LocalDate monthIterator = LocalDate.now().minusDays(LocalDate.now().getDayOfMonth() - 1);
    private GridPane gp = null;
    private BorderPane bp = null;
    private MainWindow mainWindow = null;

    private Label getMonthLabel() {
        Label l = new Label(MONTH_NAMES_FULL[monthIterator.getMonthValue() - 1] + ", " + monthIterator.getYear());
        l.setStyle("-fx-padding: 10;" +
                "-fx-min-width: 150;" +
                "-fx-min-height: 30;" +
                "-fx-background-color: #ffbebe;" +
                "-fx-font-size: 40pt;");
        return l;
    }

    public void printDot(int x, int y) {
        Label l_new = new Label(".");
        l_new.setStyle(vBoxList.get(x).get(y).getStyle());
        vBoxList.get(x).get(y).getChildren().removeLast();
        vBoxList.get(x).get(y).getChildren().add(l_new);
        vBoxList.get(x).get(y).getChildren().add(createPlusLabel(x, y));
        gp.getChildren().remove(vBoxList.get(x).get(y));
        gp.add(vBoxList.get(x).get(y), y, x + 1);
    }

    private Label createPlusLabel(int x, int y) {
        Label l = new Label("+");
        l.setStyle(vBoxList.get(x).get(y).getStyle());
        l.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            NoteCreationWindow noteCreationWindow = new NoteCreationWindow();
            noteCreationWindow.build(mainWindow, this, x, y);
        });
        return l;
    }

    private Button createUpdateButton() {
        Button l = new Button("Update Calendar");
        l.setStyle("-fx-min-width: 100;" +
                "-fx-min-height: 30;" +
                "-fx-background-color: #ffbebe;" +
                "-fx-font-size: 20pt;");
        l.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> rebuildCalendarByMonth());
        return l;
    }

    private void rebuildCalendarByMonth() {
        gp = new GridPane();
        HBox hbTop = new HBox();
        HBox hbBottom = new HBox();

        hbTop.getChildren().add(getMonthLabel());
        hbTop.getChildren().add(createUpdateButton());
        hbTop.getStyleClass().add("hbtop");
        hbBottom.getChildren().add(leftPointerButton);
        hbBottom.getChildren().add(rightPointerButton);
        hbBottom.getStyleClass().add("hbbottom");
        bp.setTop(hbTop);
        bp.setCenter(gp);
        bp.setBottom(hbBottom);
        gp.setAlignment(Pos.CENTER);
        gp.getStyleClass().add("grid");

        for (int j = 0; j < WEEK_SIZE; ++j) {
            Label dayLabel = new Label(DAYS_OF_WEEK[j]);
            dayLabel.setStyle("-fx-background-color: #ffbebe;" +
                    "-fx-min-height: 30;" +
                    "-fx-font-size: 20pt;" +
                    "-fx-min-width: 150;");
            gp.add(dayLabel, j, 0);
        }

        LocalDate curDay = monthIterator.minusDays(monthIterator.getDayOfWeek().getValue() - 1);
        int counter = 0;
        for (int i = 1; i <= MONTH_SIZE; ++i) {
            for (int j = 0; j < WEEK_SIZE; ++j) {
                VBox box = vBoxList.get(i - 1).get(j);
                box.getChildren().clear();
                int dayOfMonth = curDay.getDayOfMonth();
                Label dateLabel = new Label(String.valueOf(dayOfMonth));
                if (dayOfMonth == 1) {
                    ++counter;
                }
                box.setStyle("-fx-background-color: #ffffff;");
                dateLabel.setStyle("-fx-alignment: top-left;");
                if (counter != 1) {
                    box.setStyle("-fx-background-color: #c0c0c0;" +
                            "-fx-alignment: top-left;");
                    dateLabel.setStyle("-fx-background-color: #c0c0c0;" +
                            "-fx-alignment: top-left;");
                } else if (dayOfMonth == LocalDate.now().getDayOfMonth() &&
                        monthIterator.getMonthValue() == LocalDate.now().getMonthValue()) {
                    dateLabel.setStyle("-fx-text-fill: red;" +
                            "-fx-font-size: 20pt;" +
                            "-fx-alignment: top-left;");
                }
                box.getChildren().add(dateLabel);
                box.getChildren().add(createPlusLabel(i - 1, j));
                box.setMinWidth(150);
                box.setMinHeight(100);
                gp.add(box, j, i);
                curDay = curDay.plusDays(1);
            }
        }
    }

    public void build(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        bp = mainWindow.getBp();
        leftPointerButton.setStyle("-fx-min-width: 100;" +
                "-fx-min-height: 60;" +
                "-fx-background-color: #ffbebe;" +
                "-fx-font-size: 40pt;");
        rightPointerButton.setStyle("-fx-min-width: 100;" +
                "-fx-min-height: 60;" +
                "-fx-background-color: #ffbebe;" +
                "-fx-font-size: 40pt;");
        leftPointerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Node node = bp.getLeft();
            bp.getChildren().clear();
            bp.setLeft(node);
            monthIterator = monthIterator.minusMonths(1);
            rebuildCalendarByMonth();
        });
        rightPointerButton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            Node node = bp.getLeft();
            bp.getChildren().clear();
            bp.setLeft(node);
            monthIterator = monthIterator.plusMonths(1);
            rebuildCalendarByMonth();
        });
        for (int i = 0; i < MONTH_SIZE; ++i) {
            vBoxList.add(new ArrayList<>());
            for (int j = 0; j < WEEK_SIZE; ++j) {
                vBoxList.get(i).add(new VBox());
            }
        }
        rebuildCalendarByMonth();
    }

}
