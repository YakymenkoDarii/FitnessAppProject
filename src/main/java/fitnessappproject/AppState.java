package fitnessappproject;

import fitnessappproject.pageControllers.ExerciseTableController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;

import java.util.HashMap;
import java.util.Map;

public class AppState
{
    private static ObservableList<Tab> tabs = FXCollections.observableArrayList();
    private static final Map<String, ObservableList<ExerciseEntity>> logs = new HashMap<>();
    private static final Map<String, ObservableList<ExerciseEntity>> tabEntries = new HashMap<>();
    private static final Map<Tab, ExerciseTableController> tabControllers = new HashMap<>();


    public static ObservableList<Tab> getTabs() {
        return tabs;
    }

    public static void addTab(Tab tab) {
        if (tabs.stream().noneMatch(t -> t.getText().equals(tab.getText()))) {
            tabs.add(tab);
        }
    }
    public static void addTab(ObservableList<Tab> tabs) {
        for (Tab tab : tabs) {
            if (AppState.tabs.stream().noneMatch(t -> t.getText().equals(tab.getText()))) {
                addTab(tab);
            }
        }
    }
    public static void removeTab(Tab tab) {
        tabs.remove(tab);
    }

    public static ObservableList<ExerciseEntity> forTab(String tabTitle) {
        return logs.computeIfAbsent(tabTitle,
                k -> FXCollections.observableArrayList());
    }

    public static ObservableList<ExerciseEntity> getEntriesForTab(String tabName) {
        return tabEntries.computeIfAbsent(tabName, k -> FXCollections.observableArrayList());
    }

    public static void setEntriesForTab(String tabName, ObservableList<ExerciseEntity> entries) {
        tabEntries.put(tabName, entries);
    }



    public static void registerController(Tab tab, ExerciseTableController controller) {
        tabControllers.put(tab, controller);
    }

    public static ExerciseTableController getController(Tab tab) {
        return tabControllers.get(tab);
    }
}
