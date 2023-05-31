module com.example.provadefinitiva {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.provadefinitiva to javafx.fxml;
    exports com.example.provadefinitiva;
}