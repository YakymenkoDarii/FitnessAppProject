package fitnessappproject.pageControllers;

import fitnessappproject.abstractController.AbstractController;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExerciseAndProgressController extends AbstractController
{
    @FXML
    private BorderPane mainPane;

    @FXML
    void initialize() {
        mainPane.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.windowProperty().addListener((obs2, oldWindow, newWindow) -> {
                    if (newWindow instanceof Stage stage) {
                        newWindow.showingProperty().addListener((obs3, wasShowing, isNowShowing) -> {
                            if (isNowShowing) {
                                stage.setMaximized(true);
                            }
                        });
                    }
                });
            }
        });
    }

}

