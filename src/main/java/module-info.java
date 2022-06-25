module com.example.cvikpuj {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.cvikpuj to javafx.fxml;
    exports com.example.cvikpuj;
    exports com.example.cvikpuj.controller;
    exports com.example.cvikpuj.model;
    opens com.example.cvikpuj.controller to javafx.fxml;
    opens com.example.cvikpuj.model to javafx.fxml;
}