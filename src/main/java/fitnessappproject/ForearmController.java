package fitnessappproject;

import fitnessappproject.abstractController.AbstractController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForearmController extends AbstractController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink ExerciseLink;

    @FXML
    private Hyperlink FoodLink;

    @FXML
    private Hyperlink HomeLink;

    @FXML
    private Hyperlink WorckoutLink;

    @FXML
    void initialize() {
        WorckoutLink.setOnAction(event -> {
            changePage("Worckout.fxml", event);
        });

        ExerciseLink.setOnAction(event -> {
            changePage("ExerciseAndProgress.fxml", event);
        });

        //open food page
        FoodLink.setOnAction(event -> {
            changePage("Food.fxml", event);
        });

        HomeLink.setOnAction(event -> {
            changePage("Home.fxml", event);
        });
    }
}
