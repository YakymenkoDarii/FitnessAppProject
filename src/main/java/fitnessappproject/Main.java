package fitnessappproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fitnessappproject/Home.fxml")));
        stage.setScene(new Scene(root,700,800));
        stage.setTitle("Fitness App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}