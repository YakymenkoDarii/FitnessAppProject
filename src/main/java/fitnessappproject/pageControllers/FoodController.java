package fitnessappproject.pageControllers;

import java.net.URL;
import java.util.ResourceBundle;

import fitnessappproject.abstractController.AbstractController;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;

public class FoodController extends AbstractController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink ClubsLink;

    @FXML
    private ImageView FoodImg1;

    @FXML
    private ImageView FoodImg2;

    @FXML
    private ImageView FoodImg3;

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

        ClubsLink.setOnAction(event -> {
            changePage("SportClubs.fxml", event);
        });

        FoodLink.setOnAction(event -> {
            changePage("Food.fxml", event);
        });

        HomeLink.setOnAction(event -> {
            changePage("Home.fxml", event);
        });
    }
}

