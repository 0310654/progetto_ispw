module com.example.progetto_ispw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.progetto_ispw to javafx.fxml;
    exports com.example.progetto_ispw;
    exports com.example.progetto_ispw.dao;
    opens com.example.progetto_ispw.dao to javafx.fxml;
    exports com.example.progetto_ispw.controller;
    opens com.example.progetto_ispw.controller to javafx.fxml;
    exports com.example.progetto_ispw.view;
    opens com.example.progetto_ispw.view to javafx.fxml;
    exports com.example.progetto_ispw.model;
    opens com.example.progetto_ispw.model to javafx.fxml;
}