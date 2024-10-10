module org.application.notecalendardesktop {
    requires javafx.controls;
    requires javafx.fxml;


    exports org.application.notecalendardesktop.userinterface;
    opens org.application.notecalendardesktop.userinterface to javafx.fxml;
}