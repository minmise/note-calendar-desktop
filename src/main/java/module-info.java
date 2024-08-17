module org.application.notecalendardesktop {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.application.notecalendardesktop to javafx.fxml;
    exports org.application.notecalendardesktop;
}