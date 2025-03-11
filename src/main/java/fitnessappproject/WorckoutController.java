package fitnessappproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class WorckoutController {

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
    //changing pages
    public void changePage(String fxmlFile, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fitnessappproject/" + fxmlFile));
            Parent root = loader.load(); // Загрузка FXML и получение корневого элемента
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

