/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */



package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {

    @FXML
    private Button AddButton;

    @FXML
    private Button ClearButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private TextFlow ItemInfoTextFlow;

    @FXML
    private Label ItemNameLabel;

    @FXML
    private TextField ItemNameTextField;

    @FXML
    private Button SearchButton;

    @FXML
    private TextField SearchTextField;

    @FXML
    void addItemToInventory(ActionEvent event) {

    }

    @FXML
    void clearItemsFromInventory(ActionEvent event) {

    }

    @FXML
    void deleteItemFromInventory(ActionEvent event) {

    }

    @FXML
    void searchForItem(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void selectCell(MouseEvent mouseEvent) {

    }
}
