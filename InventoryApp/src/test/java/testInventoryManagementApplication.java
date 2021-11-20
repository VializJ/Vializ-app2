/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */


import baseline.InventoryWrapper;
import baseline.Item;
import baseline.Validate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class testInventoryManagementApplication {


    @Test
    void testAddItem() {
        //create temp observable list and fill it
        //check if the lists items are there

        ObservableList<Item> itemList = FXCollections.observableArrayList();
        InventoryWrapper.addItemToList("sampleItemName", "15.00", "A-15F-65D-447");

        itemList = InventoryWrapper.getObservableList();
        Item sampleItem = itemList.get(0);
        boolean actual = false;

        if (sampleItem.getItemName().equals("sampleItemName")) {
            actual = true;
        }
        assertEquals(true, actual);
    }
    @Test
    void testSelectItem() {

        InventoryWrapper iw = new InventoryWrapper();
        InventoryWrapper.addItemToList("sampleItemName", "15.00", "A-15F-65D-447");

        int actual = iw.selectListItem("sampleItemName");
        assertEquals(0, actual);


    }



//    @Test
//    void testRemoveItem() {
//        //create temp observable list and fill it
//        //remove the first item
//        //check to see if the item exists
//    }
//    @Test
//    void testEditItem() {
//        //create temp observable list and fill it
//        //edit the item and check if the new description is filled
//    }
//    @Test
//    void testValidateEditDescription() {
//        //create temp observable list and fill it
//        //create a sample new description that shouldn't work i.e. empty string
//        //try to add it to the observable list
//        //check to see if the item we chose to change the description of is actually changed
//    }
//    @Test
//    void testValidateEditValue() {
//        //create temp observable list and fill it
//        //create a sample new value that shouldn't work i.e. -15
//        //try to add it to the observable list
//        //check to see if the item we chose to change the value of is actually changed
//    }
//    @Test
//    void testValidateEditSerialNumber() {
//        //create temp observable list and fill it
//        //create a sample new serial number that shouldn't work i.e. one that's equal to an existing one
//        //try to add it to the observable list
//        //check to see if the item we chose to change the serial number of is actually changed
//    }
//    @Test
//    void testValidateSerialNumber() {
//        String sampleSerialNumber = "A-15F-65D-447";
//        Item cell = new Item("sampleItemName", "15.00", sampleSerialNumber);
//
//        ObservableList<Item> itemList = FXCollections.observableArrayList();
//        itemList.add(cell);
//
//        errorLabel.setText("");
//        errorLabel = Validate.validateItemSerialNumber(itemList, sampleSerialNumber, errorLabel);
//        boolean actual = false;
//
//        if (errorLabel.equals("")) {
//            actual = true;
//        }
//            assertEquals(true, actual);
//
//
//    }
}
