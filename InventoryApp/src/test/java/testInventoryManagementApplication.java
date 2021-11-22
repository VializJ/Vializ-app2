/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */


import baseline.InventoryWrapper;
import baseline.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class testInventoryManagementApplication {


    @Test
    void testAddItem() {
        //create temp observable list and fill it
        //check if the lists items are there

        ObservableList<Item> itemList;
        InventoryWrapper.addItemToList("sampleItemName", "15.00", "A-15F-65D-447");

        itemList = InventoryWrapper.getObservableList();
        Item sampleItem = itemList.get(0);
        boolean actual = sampleItem.getItemName().equals("sampleItemName");

        assertTrue(actual);
    }
    @Test
    void testSelectItem() {
        InventoryWrapper.addItemToList("sampleItemName", "15.00", "A-15F-65D-447");
        Item sampleItem = new Item("sampleItemName", "15.00", "A-15F-65D-447");

        int actual = InventoryWrapper.selectListItem(sampleItem);
        assertEquals(0, actual);
    }

    @Test
    void testRemoveItem() {
        //create temp observable list and fill it
        ObservableList<Item> currItemList = FXCollections.observableArrayList();
        currItemList.add(new Item("sampleItemName01", "100.00", "A-15F-65D-447"));
        currItemList.add(new Item("sampleItemName02", "16.42", "B-15G-69D-666"));
        InventoryWrapper.setObservableList(currItemList);
        Item itemToDelete = currItemList.get(1);
        boolean actual = false;

        String itemDeletedName = InventoryWrapper.deleteItemFromList(itemToDelete);
        //remove the first item
        //check to see if the item exists
        currItemList = InventoryWrapper.getObservableList();

        for (Item item : currItemList) {
            if (!item.equals(itemDeletedName)) {
                actual = true;
                break;
            }

        }
        assertTrue(actual);
    }
    @Test
    void testClearInventory() {
        ObservableList<Item> currItemList = FXCollections.observableArrayList();
        currItemList.add(new Item("sampleItemName01", "100.00", "A-15F-65D-447"));
        currItemList.add(new Item("sampleItemName02", "16.42", "B-15G-69D-666"));
        InventoryWrapper.setObservableList(currItemList);
        InventoryWrapper.clearInventory();
        boolean actual = false;
        currItemList = InventoryWrapper.getObservableList();
        if (currItemList.isEmpty()) {
            actual = true;
        }
        assertTrue(actual);
    }
    @Test
    void testSearch() {
        ObservableList<Item> unfilteredInventory = FXCollections.observableArrayList();
        ObservableList<Item> filteredInventory;
        boolean actual = false;

        unfilteredInventory.add(new Item("100 Dollar Bill", "100.00", "A-15F-65D-447"));
        unfilteredInventory.add(new Item("Watch", "16.42", "B-15G-69D-666"));
        unfilteredInventory.add(new Item("laptop", "17.38", "C-15G-69D-666"));
        unfilteredInventory.add(new Item("Bill the miniature robot", "00.00", "D-15G-69D-666"));
        unfilteredInventory.add(new Item("Calculator", "910.21", "E-15G-69D-666"));
        unfilteredInventory.add(new Item("American Flag", "704.76", "F-15G-69D-666"));
        unfilteredInventory.add(new Item("American Flag themed merch by Bill", "704.76", "F-15G-69D-666"));

        InventoryWrapper.setObservableList(unfilteredInventory);
        filteredInventory = InventoryWrapper.searchObservableList("Bill");
        if (filteredInventory.size() == 3) {
            actual = true;
        }
        assertTrue(actual);

    }
}
