package fitnessappproject.pageControllers;

import fitnessappproject.abstractController.AbstractController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ExerciseAndProgressController extends AbstractController
{
    @FXML
    private BorderPane mainPane;
    @FXML
    private Button homeButton;
    @FXML
    private Button foodButton;
    @FXML
    private Button musclesButton;
    @FXML
    private Button sportClubsButton;
    @FXML
    private Button exerciseAndProgressButton;

    @FXML
    void initialize()
    {
        setMaximizedWindow();

        setPictureForTheButton(homeButton, "homeButton.png");

        homeButton.setOnAction(event -> {
            changePage("Home.fxml", event);
        });
        foodButton.setOnAction(event -> {
            changePage("Food.fxml", event);
        });
        musclesButton.setOnAction(event -> {
            changePage("Worckout.fxml", event);
        });
        sportClubsButton.setOnAction(event -> {
            changePage("SportClubs.fxml", event);
        });

    }

    void setMaximizedWindow()
    {
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
    void setPictureForTheButton(Button button, String imageName)
    {
        int imageSize = 36;

        Image image = new Image(getClass().getResource("/fitnessappproject/img/imagesForMenuButtons/" + imageName).toString());
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(imageSize);
        imageView.setFitHeight(imageSize);
        imageView.setPreserveRatio(true);

        button.setGraphic(imageView);

        button.setOnMouseEntered(e -> imageView.setOpacity(0.6));
        button.setOnMouseExited(e -> imageView.setOpacity(1.0));
    }
}

