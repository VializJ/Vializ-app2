/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */



package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;

import java.io.Serial;
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
    private TableView<Item> ItemTable;

    @FXML
    private TableColumn<Item, String> NameColumn;

    @FXML
    private TableColumn<Item, String> ItemValueColumn;

    @FXML
    private TableColumn<Item, String> SerialNumberColumn;

    @FXML
    private TextFlow ItemInfoTextFlow;

    @FXML
    private Label ItemNameLabel;

    @FXML
    private TextField ItemNameTextField;

    @FXML
    private TextField ItemValueTextField;

    @FXML
    private TextField ItemSerialNumberTextField;

    @FXML
    private Button SearchButton;

    @FXML
    private TextField SearchTextField;

    @FXML
    private Label errorLabel;

    @FXML
    void addItemToInventory(ActionEvent event) {
         NameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
         ItemValueColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemPrice"));
         SerialNumberColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("ItemSerialNumber"));

         String nameText = ItemNameTextField.getText();
         String itemValue = ItemValueTextField.getText();
         String serialNumber = ItemSerialNumberTextField.getText();

        errorLabel = Validate.validateItemName(nameText, errorLabel);
        if (!errorLabel.getText().isEmpty()) {
            return;
        }

        errorLabel = Validate.validateItemValue(itemValue, errorLabel);
        if (!errorLabel.getText().isEmpty()) {
            return;
        }

        errorLabel = Validate.validateItemSerialNumber(InventoryWrapper.getObservableList(), serialNumber, errorLabel);
        if (!errorLabel.getText().isEmpty()) {
            return;
        }

        Item cell = InventoryWrapper.addItemToList(nameText, itemValue, serialNumber);
        ItemTable.getItems().add(cell);

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
