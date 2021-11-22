/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */



package baseline;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class InventoryWrapper {
        private static ObservableList<Item> itemList = FXCollections.observableArrayList();
        private static Item currentSelectedItem;


        public static ObservableList<Item> getObservableList() {
            return itemList;
        }


        public static void addItemToList(String name, String value, String serialNumber) {
            Item cell = new Item(name, value, serialNumber);
            itemList.add(cell);
            //create new text field
            //prompt user to enter the text in field
        }

        public static String deleteItemFromList(Item itemToDelete) {
            String itemToDeleteSerialNumber = "";
            int i;
            for (i = 0; i < itemList.size(); i++) {
                if (itemList.get(i).equals(itemToDelete)) {
                    //delete
                    break;
                }
            }
            itemList.remove(i);
            return itemToDeleteSerialNumber;
        }

        public static void setObservableList(ObservableList<Item> newList) {
            itemList.clear();
            itemList = newList;
        }

        public static int selectListItem(Item itemSelected) {
            int i;
            for (i = 0; i < itemList.size(); i++) {
                if (itemList.get(i).equals(itemSelected) || itemSelected.getItemSerialNumber().equals(itemList.get(i).getItemSerialNumber())) {
                        currentSelectedItem = itemList.get(i);
                        break;
                    }
                }

            return i;
            //prompt user to select item using checkbox control
            //return the selected list

        }
        public static Item getCurrentSelectedItem() {
            return currentSelectedItem;
        }
        public static void clearInventory() {
            itemList.clear();
        }
        public static ObservableList<Item> searchObservableList(String wordsToSearchFor) {
            String[] array = wordsToSearchFor.trim().split(" ");
            ObservableList<Item> filteredInventory = FXCollections.observableArrayList();

            for (String s : array) {
                for (Item item : itemList) {
                    if (item.getItemName().contains(s) || item.getItemSerialNumber().contains(s)) {
                        filteredInventory.add(item);
                    }
                }
            }

            return filteredInventory;
        }
        public static void parseHTML(File inputFile) {
            Scanner input = null;
            try {
                input = new Scanner(inputFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        public static void parseJSON(File inputFile) throws IOException {
            Gson gson = new Gson();
            itemList.clear();
            ArrayList<Item> newInventory = new ArrayList<>();

            JsonReader reader = new JsonReader(new FileReader(inputFile));

            while (reader.hasNext()) {
                Item itemFromJson = gson.fromJson(reader, Item.class);
                newInventory.add(itemFromJson);

            }



        }
    }
