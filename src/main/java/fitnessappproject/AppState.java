package fitnessappproject;

import fitnessappproject.pageControllers.ExerciseAndProgressController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;

import java.nio.charset.Charset;

public class AppState
{
    private static ObservableList<Tab> tabs = FXCollections.observableArrayList();


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
}
