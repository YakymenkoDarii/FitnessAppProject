package fitnessappproject.pageControllers;

import fitnessappproject.ExerciseEntity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.*;
import fitnessappproject.AppState;

public class ExerciseTableController {


    @FXML private TableView<ExerciseEntity> table;
    @FXML private TableColumn<ExerciseEntity,String>  colExercise;
    @FXML private TableColumn<ExerciseEntity,Integer> colSets;
    @FXML private TableColumn<ExerciseEntity,Integer> colReps;
    @FXML private TableColumn<ExerciseEntity,Double> colWeight;

    private ExerciseAndProgressController parentController;

    private String tabTitle;

    public void init(String tabTitle) {
        this.tabTitle = tabTitle;
        ObservableList<ExerciseEntity> list = AppState.forTab(tabTitle);
        table.setItems(list);
    }

    @FXML private void initialize() {
        table.setEditable(true);

        colExercise.setCellValueFactory(c -> c.getValue().exerciseProperty());
        colExercise.setCellFactory(TextFieldTableCell.forTableColumn());
        colExercise.setOnEditCommit(e ->
                e.getRowValue().setExercise(e.getNewValue()));
        colExercise.setOnEditCommit(event -> {
            ExerciseEntity entry = event.getRowValue();
            entry.setExercise(event.getNewValue());
            if (parentController != null) {
               // parentController.updateCheckBox();
            }
        });

        var intConv = new IntegerStringConverter();
        colSets.setCellValueFactory(c -> c.getValue().setsProperty().asObject());
        colSets.setCellFactory(TextFieldTableCell.forTableColumn(intConv));
        colSets.setOnEditCommit(e ->
                e.getRowValue().setSets(e.getNewValue()));

        colReps.setCellValueFactory(c -> c.getValue().repsProperty().asObject());
        colReps.setCellFactory(TextFieldTableCell.forTableColumn(intConv));
        colReps.setOnEditCommit(e ->
                e.getRowValue().setReps(e.getNewValue()));

        var dblConv = new DoubleStringConverter();
        colWeight.setCellValueFactory(c -> c.getValue().weightProperty().asObject());
        colWeight.setCellFactory(TextFieldTableCell.forTableColumn(dblConv));
        colWeight.setOnEditCommit(e ->
                e.getRowValue().setWeight(e.getNewValue()));
    }


    private static TableView<ExerciseEntity> findTableViewInTab(Tab tab) {
        Node content = tab.getContent();
        if (content instanceof Parent parent) {
            // Traverse the node tree to find the TableView
            for (Node node : parent.lookupAll(".table-view")) {
                if (node instanceof TableView<?> tableView) {
                    return (TableView<ExerciseEntity>) tableView;
                }
            }
        }
        return null;
    }

    public static void handleAddRow(TabPane tabPane) {
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        if (selectedTab == null) return;

        TableView<ExerciseEntity> table = findTableViewInTab(selectedTab);
        if (table != null) {

            ExerciseEntity newEntry = new ExerciseEntity("Exercise", 0, 0, 0);


            String tabName = selectedTab.getText();


            ObservableList<ExerciseEntity> list = AppState.forTab(tabName);
            list.add(newEntry);


            if (table.getItems() != list) {
                table.setItems(list);
            }

            table.getSelectionModel().select(newEntry);
        }
    }

    @FXML
    public static void handleDeleteRow(TabPane tabPane) {
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        if (selectedTab == null) return;

        TableView<ExerciseEntity> table = findTableViewInTab(selectedTab);
        if (table != null) {
            ExerciseEntity selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                table.getItems().remove(selected);

                String tabName = selectedTab.getText();
                AppState.forTab(tabName).remove(selected);
            }
        }
    }

    public TableView<ExerciseEntity> getTableView() {
        return table;
    }

    public void setParentController(ExerciseAndProgressController controller) {
        this.parentController = controller;
    }
}
