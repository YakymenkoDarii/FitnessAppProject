package fitnessappproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AppleGaletteController  {

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
    private ImageView galette;

    @FXML
    void initialize() {
        setupNavigation();
    }

    private void setupNavigation() {
        HomeLink.setOnAction(event -> changePage("Home.fxml", event));
        FoodLink.setOnAction(event -> changePage("Food.fxml", event));
        WorckoutLink.setOnAction(event -> changePage("Worckout.fxml", event));
        ExerciseLink.setOnAction(event -> changePage("ExerciseAndProgress.fxml", event));


        styleHyperlink(HomeLink);
        styleHyperlink(FoodLink);
        styleHyperlink(WorckoutLink);
        styleHyperlink(ExerciseLink);
    }

    public void changePage(String fxmlFile, ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fitnessappproject/" + fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void styleHyperlink(Hyperlink link) {
        if (link != null) {
            link.setStyle("-fx-text-fill: #ECF0F1; -fx-border-color: transparent;");
            link.setOnMouseEntered(e -> link.setStyle("-fx-text-fill: #1ABC9C; -fx-border-color: transparent;"));
            link.setOnMouseExited(e -> link.setStyle("-fx-text-fill: #ECF0F1; -fx-border-color: transparent;"));
        }
    }
}
