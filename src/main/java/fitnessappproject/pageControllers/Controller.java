package fitnessappproject.pageControllers;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.prefs.Preferences;
import java.util.ResourceBundle;

import fitnessappproject.abstractController.AbstractController;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller extends AbstractController {


    @FXML
    private ImageView FoodImg, ProgramsImg, SportImg;
    @FXML
    private Hyperlink ClubsLink, FoodLink, HomeLink, WorckoutLink, ExerciseAndProgressLink;
    @FXML
    private Hyperlink FoodMoreLink, ProgramsMoreLink, ClubsMoreLink;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    // For Tips panel
    @FXML
    private VBox tipsPanel;
    @FXML
    private Label tipContent;
    @FXML
    private Button nextTipButton;
    @FXML
    private Button closeTipsButton;

    private final List<String> tips = Arrays.asList(
            "Drink at least 2 liters of water per day.",
            "Warm up before training to avoid injuries.",
            "Sleep 7-8 hours each night for recovery.",
            "Increase the load gradually — no need to rush.",
            "Balanced nutrition is the basis of progress."
    );


    private final Random random = new Random();
    private final Preferences prefs = Preferences.userNodeForPackage(Controller.class);


    @FXML
    void initialize() {

        setupNavigation();

        setupImageHoverEffects();

        setupTooltips();

        setupTipsPanel();
    }

    private void setupNavigation() {
        //  for navigation links
        HomeLink.setOnAction(event -> changePage(FXMLPath + "Home.fxml", event));
        FoodLink.setOnAction(event -> changePage(FXMLPath + "Food.fxml", event));
        WorckoutLink.setOnAction(event -> changePage(FXMLPath + "Worckout.fxml", event));
        ClubsLink.setOnAction(event -> changePage(FXMLPath + "SportClubs.fxml", event));

        //  for "Read more" links
        FoodMoreLink.setOnAction(event -> changePage(FXMLPath + "Food.fxml", event));
        ProgramsMoreLink.setOnAction(event -> changePage(FXMLPath + "Worсkout.fxml", event));
        ClubsMoreLink.setOnAction(event -> changePage(FXMLPath + "SportClubs.fxml", event));

        //  images clickable
        FoodImg.setOnMouseClicked(event -> changePage(FXMLPath + "Food.fxml", event));
        ProgramsImg.setOnMouseClicked(event -> changePage(FXMLPath + "Worckout.fxml", event));
        SportImg.setOnMouseClicked(event -> changePage(FXMLPath + "SportClubs.fxml", event));

        // Style all hyperlinks
        styleHyperlink(HomeLink);
        styleHyperlink(FoodLink);
        styleHyperlink(WorckoutLink);
        styleHyperlink(ClubsLink);
        styleHyperlink(FoodMoreLink);
        styleHyperlink(ProgramsMoreLink);
        styleHyperlink(ClubsMoreLink);
        styleHyperlink(ExerciseAndProgressLink);
    }

    private void setupImageHoverEffects() {

        ExerciseAndProgressLink.setOnAction(event -> {
            changePage(FXMLPath + "ExerciseAndProgress.fxml", event);
        });

        setHoverEffect(FoodImg);
        setHoverEffect(ProgramsImg);
        setHoverEffect(SportImg);
    }

    private void setHoverEffect(ImageView image) {
        if (image != null) {
            image.setOnMouseEntered(this::onHover);
            image.setOnMouseExited(this::onExit);
        }
    }

    private void setupTooltips() {
        // Add tooltips to images
        Tooltip.install(FoodImg, new Tooltip("Explore healthy food ideas"));
        Tooltip.install(ProgramsImg, new Tooltip("Browse training programs"));
        Tooltip.install(SportImg, new Tooltip("Find gyms and clubs nearby"));
    }

    private void setupTipsPanel() {
        tipsPanel.setVisible(true);
        showRandomTip();

        // Set up buttons
        nextTipButton.setOnAction(e -> showRandomTip());
        closeTipsButton.setOnAction(e -> closeTipsPanel());
    }

    private void showRandomTip() {
        int index = random.nextInt(tips.size());
        tipContent.setText(tips.get(index));
    }

    private void closeTipsPanel() {
        prefs.putBoolean("tipsClosed", true);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), tipsPanel);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(e -> tipsPanel.setVisible(false));
        fadeOut.play();
    }

    private void styleHyperlink(Hyperlink link) {
        if (link != null) {
            link.setStyle("-fx-text-fill: #ECF0F1; -fx-border-color: transparent;");
            link.setOnMouseEntered(e -> link.setStyle("-fx-text-fill: #1ABC9C; -fx-border-color: transparent;"));
            link.setOnMouseExited(e -> link.setStyle("-fx-text-fill: #ECF0F1; -fx-border-color: transparent;"));
        }
    }

    public void changePage(String fxmlFile, ActionEvent event) {
        loadPage(fxmlFile, (Node) event.getSource());
    }

    private void changePage(String fxmlFile, MouseEvent event) {
        loadPage(fxmlFile, (Node) event.getSource());
    }

    private void loadPage(String fxmlFile, Node sourceNode) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) sourceNode.getScene().getWindow();
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
    }

    @FXML
    public void onExit(MouseEvent event) {
        ImageView img = (ImageView) event.getSource();
        img.setScaleX(1.0);
        img.setScaleY(1.0);
    }
}
