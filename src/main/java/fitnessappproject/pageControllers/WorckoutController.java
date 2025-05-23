package fitnessappproject.pageControllers;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import fitnessappproject.abstractController.AbstractController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class WorckoutController extends AbstractController {


    public ImageView PhotoId;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView AbdominalId;

    @FXML
    private ImageView AssId;

    @FXML
    private ImageView BackId;

    @FXML
    private ImageView BackLegId;

    @FXML
    private ImageView BicepsId;

    @FXML
    private ImageView CalfId;

    @FXML
    private ImageView ChestId;

    @FXML
    private Hyperlink FoodLink;

    @FXML
    private Hyperlink ExercisesLink;

    @FXML
    private ImageView ForearmId;

    @FXML
    private Label GymLink;

    @FXML
    private Hyperlink HomeLink;

    @FXML
    private ImageView LowerBackId;

    @FXML
    private ImageView ObliquesId;

    @FXML
    private ImageView SholdersId;

    @FXML
    private ImageView TrapeId;

    @FXML
    private ImageView TrapsMidleId;

    @FXML
    private ImageView TricepsId;

    @FXML
    private Label VideosLink;

    @FXML
    private Hyperlink WorckoutLink;

    @FXML
    private ImageView LegId;

    @FXML
    void initialize() {
        if (AbdominalId == null) {
            System.out.println("AbdomilamsId is null!");
        } else {

            AbdominalId.setOnMouseClicked((MouseEvent event) -> {
                openPage("AbdominalInfo.fxml", event);
            });
            AssId.setOnMouseClicked((MouseEvent event) -> {
               openPage("Ass.fxml", event);
                System.out.println(" bud work");
            });
            BackId.setOnMouseClicked((MouseEvent event) -> {
                openPage("Back.fxml", event);
                System.out.println("Back work");
            });
            BackLegId.setOnMouseClicked((MouseEvent event) -> {
                  openPage("Leg.fxml", event);
                System.out.println("Back Leg work");
            });
            BicepsId.setOnMouseClicked((MouseEvent event) -> {
                openPage("Biceps.fxml", event);
                System.out.println("Biceps work");
            });
            CalfId.setOnMouseClicked((MouseEvent event) -> {
                openPage("Calf.fxml", event);
                System.out.println("Calf work");
            });
            ChestId.setOnMouseClicked((MouseEvent event) -> {
                openPage("Chest.fxml", event);
                System.out.println("Chest work");
            });
            ForearmId.setOnMouseClicked((MouseEvent event) -> {
                openPage("Forearm.fxml", event);
                System.out.println("Forearm work");
            });
            LowerBackId.setOnMouseClicked((MouseEvent event) -> {
                openPage("LowerBack.fxml", event);
                System.out.println("LowerBack work");
            });
            ObliquesId.setOnMouseClicked((MouseEvent event) -> {
                openPage("Obliques.fxml", event);
                System.out.println("Obliques work");
            });
            SholdersId.setOnMouseClicked((MouseEvent event) -> {
                openPage("ShouldersInfo.fxml", event);
                System.out.println("Sholders work");
            });
            TrapeId.setOnMouseClicked((MouseEvent event) -> {
                openPage("Trap.fxml", event);
                System.out.println("Trap work");
            });
            TrapsMidleId.setOnMouseClicked((MouseEvent event) -> {
                openPage("TrapMiddle.fxml", event);
                System.out.println("TrapMidle work");
            });
            TricepsId.setOnMouseClicked((MouseEvent event) -> {
                openPage("Triceps.fxml", event);
                System.out.println("Triceps work");
            });
            LegId.setOnMouseClicked((MouseEvent event) -> {
                openPage("Leg.fxml", event);
                System.out.println("Leg work");
            });
            ExercisesLink.setOnAction(event -> {
                changePage("ExerciseAndProgress.fxml", event);
            });

        }

        WorckoutLink.setOnAction(event -> changePage("Worckout.fxml", event));

        FoodLink.setOnAction(event -> changePage("Food.fxml", event));

        HomeLink.setOnAction(event -> changePage("Home.fxml", event));

    }

    //changing pages
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

    public void openPage(String fxmlFile, MouseEvent event) {
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
}



