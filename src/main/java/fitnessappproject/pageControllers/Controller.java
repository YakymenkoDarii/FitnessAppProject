package fitnessappproject.pageControllers;

import java.net.URL;
import java.util.ResourceBundle;

import fitnessappproject.abstractController.AbstractController;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;


public class Controller extends AbstractController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink ClubsLink;

    @FXML
    private Hyperlink FoodLink;

    @FXML
    private Hyperlink HomeLink;

    @FXML
    private Hyperlink WorckoutLink;

    @FXML
    private Hyperlink ExerciseAndProgressLink;

    @FXML
    void initialize() {
        WorckoutLink.setOnAction(event -> {
            changePage("Worckout.fxml", event);
        });

        ClubsLink.setOnAction(event -> {
            changePage("SportClubs.fxml", event);
        });

        //open food page
        FoodLink.setOnAction(event -> {
            changePage("Food.fxml", event);
        });

        HomeLink.setOnAction(event -> {
            changePage("Home.fxml", event);
        });

        ExerciseAndProgressLink.setOnAction(event -> {
            changePage("ExerciseAndProgress.fxml", event);
        });

    }
}

