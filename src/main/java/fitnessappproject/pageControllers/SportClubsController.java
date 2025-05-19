package fitnessappproject.pageControllers;

import java.net.URL;
import java.util.ResourceBundle;

import fitnessappproject.abstractController.AbstractController;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;


public class SportClubsController extends AbstractController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink ClubsLink;

    @FXML
    private Hyperlink FoodLink;

    @FXML
    private Label GymLink;

    @FXML
    private Hyperlink HomeLink;

    @FXML
    private Label VideosLink;

    @FXML
    private Hyperlink WorckoutLink;
    @FXML
    private Hyperlink ExercisesLink;

    @FXML
    void initialize() {

        WorckoutLink.setOnAction(event -> {
            changePage("Worckout.fxml", event);
        });

        ClubsLink.setOnAction(event -> {
            changePage("SportClubs.fxml", event);
        });

        FoodLink.setOnAction(event -> {
            changePage("Food.fxml", event);
        });

        HomeLink.setOnAction(event -> {
            changePage("Home.fxml", event);
        });
        ExercisesLink.setOnAction(event -> {
            changePage("ExerciseAndProgress.fxml", event);
        });
    }
}

