package fitnessappproject.abstractController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class AbstractController
{
    String FXMLPath = "/fitnessappproject/";
    public void changePage(String fxmlFile, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource( FXMLPath + fxmlFile));
            Parent root = loader.load(); // Загрузка FXML и получение корневого элемента
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            if (fxmlFile.contains("ExerciseAndProgress.fxml")) {
                stage.setMaximized(true);
            }
            stage.setScene(new Scene(root));

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
