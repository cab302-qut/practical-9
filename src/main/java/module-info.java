module com.example.javafxthread {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;


    opens com.example.javafxthread to javafx.fxml;
    exports com.example.javafxthread;
    exports com.example.javafxthread.exercise2.dummyjson;
    opens com.example.javafxthread.exercise2.dummyjson to javafx.fxml;
    exports com.example.javafxthread.exercise1;
    opens com.example.javafxthread.exercise1 to javafx.fxml;
    exports com.example.javafxthread.exercise2;
    opens com.example.javafxthread.exercise2 to javafx.fxml;
}