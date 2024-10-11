module org.application.notecalendardesktop {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.web;


    exports org.application.notecalendardesktop.userinterface;
    opens org.application.notecalendardesktop.userinterface to javafx.fxml;
}