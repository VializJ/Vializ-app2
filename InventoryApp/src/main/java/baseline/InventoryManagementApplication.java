/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */



package baseline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class InventoryManagementApplication extends Application {
    Stage globalStage;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("InventoryManagementApplicationUI'.fxml"));
        Scene scene = new Scene(root);
        globalStage = stage;
        stage.setTitle("Inventory");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public File saveFileHTML() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save as HTML");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("HTML Document", "*.html"));
        return fc.showSaveDialog(globalStage);
    }

    public File saveFileTSV() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save as Tab Separated");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Document", "*.txt"));
        return fc.showSaveDialog(globalStage);
    }

    public File saveFileJSON() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save as JSON");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JSON File", "*.json"));
        return fc.showSaveDialog(globalStage);
    }

    public File loadFile() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Load Inventory");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Allowed File Types" , "*.json", "*.txt", "*.html"));
        return fc.showOpenDialog(globalStage);
    }
}

