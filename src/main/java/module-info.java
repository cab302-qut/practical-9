module com.example.javafxthread {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxthread to javafx.fxml;
    exports com.example.javafxthread;
}