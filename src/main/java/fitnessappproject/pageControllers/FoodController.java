package fitnessappproject.pageControllers;

import fitnessappproject.abstractController.AbstractController;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FoodController extends AbstractController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink ClubsLink;

    @FXML
    private Hyperlink ExerciseLink;

    @FXML
    private Hyperlink FoodLink;

    @FXML
    private Hyperlink HomeLink;

    @FXML
    private Hyperlink WorckoutLink;

    @FXML
    private ImageView eggs;

    @FXML
    private ImageView galette;

    @FXML
    private ImageView maple;

    @FXML
    private ImageView seafood;


    @FXML
    void initialize() {
        setupNavigation();
        setupHoverEffects();
        setupImageClickHandlers(); // Добавим переход по фото
    }

    private void setupNavigation() {
        HomeLink.setOnAction(event -> changePage("Home.fxml", event));
        FoodLink.setOnAction(event -> changePage("Food.fxml", event));
        WorckoutLink.setOnAction(event -> changePage("Worckout.fxml", event));
        ClubsLink.setOnAction(event -> changePage("SportClubs.fxml", event));
        ExerciseLink.setOnAction(event -> changePage("ExerciseAndProgress.fxml", event));

        styleHyperlink(HomeLink);
        styleHyperlink(FoodLink);
        styleHyperlink(WorckoutLink);
        styleHyperlink(ClubsLink);
        styleHyperlink(ExerciseLink);
    }

    private void setupImageClickHandlers() {
        eggs.setOnMouseClicked(event -> changePage("SpanishEggs.fxml", event));
        maple.setOnMouseClicked(event -> changePage("MapleGranola.fxml", event));
        seafood.setOnMouseClicked(event -> changePage("SeafoodGratin.fxml", event));
        galette.setOnMouseClicked(event -> changePage("AppleGalette.fxml", event));

    }

    private void setupHoverEffects() {
        setHoverEffect(maple);
        setHoverEffect(seafood);
        setHoverEffect(eggs);
        setHoverEffect(galette);
    }

    private void setHoverEffect(ImageView imageView) {
        if (imageView != null) {
            imageView.setOnMouseEntered(this::onHover);
            imageView.setOnMouseExited(this::onExit);
        }
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

    public void changePage(String fxmlFile, MouseEvent event) {
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

    @FXML
    public void onHover(MouseEvent event) {
        ImageView img = (ImageView) event.getSource();
        img.setScaleX(1.05);
        img.setScaleY(1.05);
        Glow glow = new Glow();
        glow.setLevel(0.3);
        img.setEffect(glow);

        ScaleTransition scale = new ScaleTransition(Duration.millis(200), img);
        scale.setToX(1.05);
        scale.setToY(1.05);
        scale.play();
    }

    @FXML
    public void onExit(MouseEvent event) {
        ImageView img = (ImageView) event.getSource();

        ScaleTransition scale = new ScaleTransition(Duration.millis(200), img);
        scale.setToX(1.0);
        scale.setToY(1.0);
        scale.setOnFinished(e -> img.setEffect(null));
        scale.play();
    }

    private void styleHyperlink(Hyperlink link) {
        if (link != null) {
            link.setStyle("-fx-text-fill: #ECF0F1; -fx-border-color: transparent;");
            link.setOnMouseEntered(e -> link.setStyle("-fx-text-fill: #1ABC9C; -fx-border-color: transparent;"));
            link.setOnMouseExited(e -> link.setStyle("-fx-text-fill: #ECF0F1; -fx-border-color: transparent;"));
        }
    }
}
