package fitnessappproject.pageControllers;

import fitnessappproject.AppState;
import fitnessappproject.ExerciseEntry;
import fitnessappproject.abstractController.AbstractController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

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
    private Button exercisesAndProgressButton;

    @FXML
    public TabPane tabPane;
    @FXML
    private Button addGroupButton;
    @FXML
    private Button deleteGroupButton;

    @FXML
    private Button addExerciseButton;
    @FXML
    private Button deleteExerciseButton;

    @FXML
    private Button saveLogButton;
    @FXML
    private TextField weightTextField;
    @FXML
    private DatePicker datePicker;
    @FXML
    private ComboBox<String> exerciseComboBox;

    Tab selectedTab;
    Node content;

    @FXML
    void initialize()
    {
        //setMaximizedWindow();

        tabPane.getTabs().setAll(AppState.getTabs());

        setPictureForTheButton(homeButton, "HomeButton.png");
        setPictureForTheButton(foodButton, "FoodButton.png");
        setPictureForTheButton(musclesButton, "MusclesButton.png");
        setPictureForTheButton(exercisesAndProgressButton, "ExercisesAndProgressButton.png");

        homeButton.setOnAction(event -> {
            changePage("Home.fxml", event);
        });
        foodButton.setOnAction(event -> {
            changePage("Food.fxml", event);
        });
        musclesButton.setOnAction(event -> {
            changePage("Worckout.fxml", event);
        });
        addGroupButton.setOnAction(event -> {
            createNewTab();
           // updateCheckBox();
        });
        deleteGroupButton.setOnAction(event -> {
            deleteTab();
            //updateCheckBox();
        });

        addExerciseButton.setOnAction(e -> {
            ExerciseTableController.handleAddRow(tabPane);
           // updateCheckBox();
        });
        deleteExerciseButton.setOnAction(e -> {
            ExerciseTableController.handleDeleteRow(tabPane);
            //updateCheckBox();
        });
        tabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
            if (newTab != null) {
                //updateCheckBox();
            }
        });
    }

//    void setMaximizedWindow()
//    {
//        mainPane.sceneProperty().addListener((obs, oldScene, newScene) -> {
//            if (newScene != null) {
//                newScene.windowProperty().addListener((obs2, oldWindow, newWindow) -> {
//                    if (newWindow instanceof Stage stage) {
//                        newWindow.showingProperty().addListener((obs3, wasShowing, isNowShowing) -> {
//                            if (isNowShowing) {
//                                stage.setMaximized(true);
//                            }
//                        });
//                    }
//                });
//            }
//        });
//    }
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

    void createNewTab()
    {
        Dialog<String> tabDialog = new Dialog<>();
        VBox vBox = new VBox();
        Label label = new Label("Enter tab name:");
        TextField textField = new TextField();
        textField.setPromptText("Enter name, example: \"Friday\"");
        ButtonType addButtonType = new ButtonType("Add Tab", ButtonBar.ButtonData.OK_DONE);

        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER_LEFT);
        vBox.getChildren().addAll(label, textField);

        tabDialog.setTitle("Create New Tab");
        tabDialog.getDialogPane().setContent(vBox);
        tabDialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        Node addButton = tabDialog.getDialogPane().lookupButton(addButtonType);
        addButton.setDisable(true);

        textField.textProperty().addListener((obs, oldVal, newVal) -> {
            addButton.setDisable(newVal.trim().isEmpty());
        });

        tabDialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButtonType) {
                return textField.getText().trim();
            }
            return null;
        });

        tabDialog.showAndWait().ifPresent(tabName -> {
            System.out.println("New Tab Name: " + tabName);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fitnessappproject/TabContent.fxml"));
            try {
                Parent tabContent = loader.load();

                ExerciseTableController ctrl = loader.getController();
                ctrl.setParentController(this);

                Tab newTab = new Tab(tabName);

                StackPane stackPane = new StackPane(tabContent);
                stackPane.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

                newTab.setContent(stackPane);
                if(tabPane.getTabs().stream().noneMatch(t -> t.getText().equals(tabName))) {
                    ctrl.init(tabName);
                    AppState.addTab(newTab);
                    AppState.registerController(newTab, ctrl);
                    tabPane.getTabs().add(newTab);
                    //updateCheckBox();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    void deleteTab()
    {
        Tab tabForDelete = tabPane.getSelectionModel().getSelectedItem();
        if (tabForDelete != null) {
            Dialog<Object> deleteDialog = new Dialog<>();
            deleteDialog.setContentText("Are you sure you want to delete \"" + tabForDelete.getText().trim() + "\" Tab?");
            deleteDialog.getDialogPane().getButtonTypes().addAll(ButtonType.NO, ButtonType.YES);
            deleteDialog.showAndWait().ifPresent(dialog -> {
                tabPane.getTabs().remove(tabForDelete);
                AppState.removeTab(tabForDelete);
                //updateCheckBox();
            });
        }
    }

//    public void updateCheckBox() {
//        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
//        if (selectedTab == null) return;
//
//        ExerciseTableController controller = AppState.getController(selectedTab);
//        if (controller == null) {
//            System.out.println("No controller found for selected tab.");
//            return;
//        }
//
//        TableView<ExerciseEntry> table = controller.getTableView();
//        ObservableList<ExerciseEntry> items = table.getItems();
//
//        ObservableList<String> names = FXCollections.observableArrayList();
//        for (ExerciseEntry entry : items) {
//            names.add(entry.getExercise());
//        }
//        exerciseComboBox.setItems(names);
//    }
}

