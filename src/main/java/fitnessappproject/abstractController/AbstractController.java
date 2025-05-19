package fitnessappproject.abstractController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public abstract class AbstractController
{
    public final String FXMLPath = "/fitnessappproject/";
    public void changePage(String fxmlFile, ActionEvent event) {
        String fullPath = FXMLPath + fxmlFile;
        URL url = getClass().getResource(fullPath);
        if (url == null) {
            System.err.println("FXML NOT FOUND → " + fullPath);
            return;
        }

        try {
            Parent root = FXMLLoader.load(url);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            if (fxmlFile.contains("ExerciseAndProgress.fxml")) stage.setMaximized(true);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
