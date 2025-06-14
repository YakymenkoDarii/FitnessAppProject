module com.example.fitnessappproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.desktop;
    requires java.prefs;

    opens fitnessappproject to javafx.fxml;
    exports fitnessappproject;
    exports fitnessappproject.pageControllers;
    opens fitnessappproject.pageControllers to javafx.fxml;
}