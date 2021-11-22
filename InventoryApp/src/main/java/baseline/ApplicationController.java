/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */



package baseline;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.TextFlow;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ApplicationController implements Initializable {
    private Integer currItemIndex;

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
    private Button RevertSearchButton;

    @FXML
    private MenuItem SaveAsHTMLFileOption;

    @FXML
    private MenuItem SaveAsJSONFileOption;

    @FXML
    private MenuItem SaveAsTSVFileOption;

    @FXML
    private MenuItem loadInventory;

    @FXML
    void addItemToInventory(ActionEvent event) {
        NameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
        ItemValueColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemPrice"));
        SerialNumberColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("ItemSerialNumber"));

        String nameText = ItemNameTextField.getText();
        String itemValue = ItemValueTextField.getText();
        String serialNumber = ItemSerialNumberTextField.getText();

        errorLabel.setText(Validate.validateItemName(nameText));
        if (!errorLabel.getText().isEmpty()) {
            return;
        }
        errorLabel.setText(Validate.validateItemValue(itemValue));
        if (!errorLabel.getText().isEmpty()) {
            return;
        }
        errorLabel.setText(Validate.validateItemSerialNumber(InventoryWrapper.getObservableList(), serialNumber));
        if (!errorLabel.getText().isEmpty()) {
            return;
        }

        InventoryWrapper.addItemToList(nameText, itemValue, serialNumber);
        ItemTable.setItems(InventoryWrapper.getObservableList());
        ItemNameTextField.setText("");
        ItemValueTextField.setText("");
        ItemSerialNumberTextField.setText("");


    }

    @FXML
    void clearItemsFromInventory(ActionEvent event) {
        InventoryWrapper.clearInventory();
        ItemTable.getItems().clear();
    }

    @FXML
    void deleteItemFromInventory(ActionEvent event) {
        ObservableList<Item> newInventory = ItemTable.getItems();
        //Make a list to hold the table items
        //Item itemToDelete = ItemTable.getSelectionModel().getSelectedItem();
        Item itemToDelete = InventoryWrapper.getCurrentSelectedItem();
        //find the item we want to delete
        newInventory.remove(itemToDelete);

        InventoryWrapper.deleteItemFromList(itemToDelete);

        System.out.println(InventoryWrapper.getObservableList());
        ItemTable.setItems(InventoryWrapper.getObservableList());
    }

    @FXML
    void searchForItem(ActionEvent event) {
        ItemTable.getItems().clear();
        ItemTable.getItems().addAll(InventoryWrapper.searchObservableList(SearchTextField.getText()));
        SearchTextField.clear();
    }

    @FXML
    void revertSearch(ActionEvent event) {
        ItemTable.getItems().clear();
        ItemTable.getItems().addAll(InventoryWrapper.getObservableList());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ItemTable.setEditable(true);

        NameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ItemValueColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        SerialNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }
    @FXML
    void selectCell(MouseEvent event) {
        if (event.getClickCount() == 1) {
            //try {
                InventoryWrapper inventoryWrapper = new InventoryWrapper();
                currItemIndex = inventoryWrapper.selectListItem(ItemTable.getSelectionModel().getSelectedItem());
                //currentItemSelected.setText("Currently selected task: " + ItemTable.getSelectionModel().getSelectedItem().getItemName());
                //update the currItemIndex with index of the currently selected cell
//            } catch (Exception e) {
//                currentItemSelected.setText("Currently selected task: ");
//            }
        }
        
    }
    @FXML
    void editName(TableColumn.CellEditEvent<Item, String> editedCell) {
        ObservableList<Item> inventory = InventoryWrapper.getObservableList();

        Item itemToChange = ItemTable.getSelectionModel().getSelectedItem();
        String newItemName = editedCell.getNewValue().toString();


        if (newItemName.length() > 256) {
            errorLabel.setText("Too many characters try again");
            return;
        }else if(newItemName.length() < 2) {
            errorLabel.setText("Too few characters try again");
            return;
        }
        itemToChange.setItemName(newItemName);
        NameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
    }

    @FXML
    void editItemValue(TableColumn.CellEditEvent<Item, String> editedCell) {
           ObservableList<Item> inventory = InventoryWrapper.getObservableList();
            ItemValueColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemPrice"));
            Item itemToChange = ItemTable.getSelectionModel().getSelectedItem();
        Double convertedNewItemValue = 0.00;
            String newItemValue = editedCell.getNewValue().toString();
                if (newItemValue.matches("[A-Za-z]") || newItemValue.isEmpty()) {
                    errorLabel.setText("Value cannot contain letters");
                    convertedNewItemValue = Double.parseDouble(newItemValue);
                    return;
                }

            if (convertedNewItemValue < 0.00) {
                errorLabel.setText("Value must be greater than or equal to 0 USD");
                return;
            }

            if (            newItemValue.matches("\\d.\\d{2}") ||
                            newItemValue.matches("\\d{2}.\\d{2}") ||
                            newItemValue.matches("\\d{3}.\\d{2}") ||
                            newItemValue.matches("\\d{4}.\\d{2}") ||
                            newItemValue.matches("\\d{5}.\\d{2}") ||
                            newItemValue.matches("\\d{6}.\\d{2}") ||
                            newItemValue.matches("\\d{7}.\\d{2}") ||
                            newItemValue.matches("\\d{8}.\\d{2}") ||
                            newItemValue.matches("\\d{9}.\\d{2}")) {
                itemToChange.setItemPrice(newItemValue);
            } else {
                errorLabel.setText("Incorrect Item Value format");
                return;
            }
            for (int i = 0; i < InventoryWrapper.getObservableList().size(); i++) {
                if (InventoryWrapper.getObservableList().get(i).equals(itemToChange)) {
                    InventoryWrapper.getObservableList().get(i).setItemPrice(newItemValue);
                    break;
                }
            }


            return;
        }



    @FXML
    void editSerialNumber(TableColumn.CellEditEvent<Item, String> editedCell) {
        ObservableList<Item> inventory = InventoryWrapper.getObservableList();


        Item itemToChange = ItemTable.getSelectionModel().getSelectedItem();
        String serialNumberToValidate = editedCell.getNewValue().toString();

        if (!serialNumberToValidate.matches("[A-Za-z]-[A-Za-z0-9]{3}-[A-Za-z0-9]{3}-[A-Za-z0-9]{3}")) {
            errorLabel.setText("Serial number not in correct format try again");
            return;
        }
//        for (int i = 0; i < itemList.size(); i++) {
//            if (serialNumber.equals(itemList.get(i).getItemSerialNumber())) {
//                System.out.println(serialNumber);
//                System.out.println(itemList.get(i).getItemSerialNumber());
//                errorLabel.setText("Serial number already exists try again");
//                return;
//            }
        for (int i = 0; i < InventoryWrapper.getObservableList().size(); i++) {
            if (serialNumberToValidate.equals(InventoryWrapper.getObservableList().get(i).getItemSerialNumber())) {
            errorLabel.setText("Serial number already exists try again");
                return;
            }else {
                continue;
            }
        }

        SerialNumberColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("ItemSerialNumber"));



    }
    @FXML
    void saveAsHTML(ActionEvent event) throws FileNotFoundException {

        /* <table> </table> table tag signifies that start and end of a table in HTML
        *  <tr> </tr>     table row tag that represents a row
        *  <td> </td>     table cell tag that represents a singular cell
        *
        * <thead> </thead> table header that we'll use to name the table
        *
        *
        *
        * make the item name, value and serial number column headers into cells within HTML,
        * this will signify to the parser where to start taking information from
        *
        * */

        InventoryManagementApplication IMA = new InventoryManagementApplication();
        //InventoryWrapper.setObservableList(ItemTable.getItems());
        ObservableList<Item> inventoryToFile = InventoryWrapper.getObservableList();


       File outputFile = IMA.saveFileHTML();
       PrintWriter pw = new PrintWriter(outputFile);
        String rowAlign = "\t";
        String cellAlign = "\t\t";



       /*Initial names of the columns*/
       pw.write("<table>\n" + rowAlign + "<tr>\n" +
               cellAlign + "<td>&nbsp;</td>\n" +
               cellAlign + "<td>ItemName</td>\n" +
               cellAlign + "<td>ItemValue</td>\n" +
               cellAlign + "<td>ItemSerialNumber</td>\n" +
               rowAlign + "</tr>\n"
       );

        int numberOfInventoryItems = inventoryToFile.size();
        String tableRowToPrint;
       if (outputFile.exists()) {
           for (int i = 0; i < numberOfInventoryItems; i++) {
               String itemNumber = "Item number: " + (i+1);
               tableRowToPrint = "<tr>\n" + rowAlign + "<td>" + itemNumber + "</td>\n";
                tableRowToPrint = tableRowToPrint + cellAlign + "<td>" +
                       inventoryToFile.get(i).getItemName() + "</td>\n" + cellAlign + "<td>" +
                       inventoryToFile.get(i).getItemPrice() + "</td>\n" + cellAlign + "<td>" +
                       inventoryToFile.get(i).getItemSerialNumber() + "</td>\n" + rowAlign +
                        "</tr>\n";
            pw.write(tableRowToPrint);
           }
           pw.write("</table>");
           pw.close();
       }

    }

    @FXML
    void saveAsTSV(ActionEvent event) throws FileNotFoundException {
        InventoryManagementApplication IMA = new InventoryManagementApplication();
        File outputFile = IMA.saveFileTSV();

            PrintWriter pw = new PrintWriter(outputFile);

        ObservableList<Item> inventoryToFile = InventoryWrapper.getObservableList();
        String line;
        for (int i = 0; i < inventoryToFile.size(); i++) {
            line =  inventoryToFile.get(i).getItemName() + "\t" +
                    inventoryToFile.get(i).getItemPrice() + "\t" +
                    inventoryToFile.get(i).getItemSerialNumber() + "\t\n";
            pw.write(line);
        }
        pw.close();

    }
    @FXML
    void saveAsJSON(ActionEvent event) throws FileNotFoundException {
        ObservableList<Item> inventoryToFile = InventoryWrapper.getObservableList();
        Gson gson = new Gson();
        InventoryManagementApplication IMA = new InventoryManagementApplication();
        File outputFile = IMA.saveFileJSON();



        PrintWriter pw = new PrintWriter(outputFile);
        pw.write(gson.toJson(InventoryWrapper.getObservableList()));


        pw.close();

    }


    @FXML
    void loadInventory(ActionEvent event) throws IOException {
        NameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
        ItemValueColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemPrice"));
        SerialNumberColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("ItemSerialNumber"));


        InventoryManagementApplication IMA = new InventoryManagementApplication();
        File inputFile = IMA.loadFile();

        String fileName = inputFile.getName();

        for (int i = 0; i < fileName.length(); i++) {
            if (fileName.contains(".txt")) {
                    ObservableList<Item> currObservableList = FXCollections.observableArrayList();
                    Scanner input = null;

                    try {
                        input = new Scanner(inputFile);

                        String[] itemAttributes;
                        while(input.hasNext()) {
                            itemAttributes = input.nextLine().split("\t");
                            Item itemFromList = new Item(itemAttributes[0], itemAttributes[1], itemAttributes[2]);

                            currObservableList.add(itemFromList);
                        }
                        InventoryWrapper.setObservableList(currObservableList);
                        ItemTable.setItems(InventoryWrapper.getObservableList());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                //load tsv parser
                //InventoryWrapper.parseTSV(inputFile);
            }else if (fileName.contains(".json")) {
                //load json parser
                InventoryWrapper.parseJSON(inputFile);
            }else if(fileName.contains(".html")) {
                //load HTML parser

                InventoryWrapper.parseHTML(inputFile);
            }
        }
        //ItemTable.setItems(InventoryWrapper.getObservableList());



    }



}
