/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */



package baseline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class InventoryWrapper {
        private static ObservableList<Item> itemList = FXCollections.observableArrayList();
        private static Item currentSelectedItem;


        public static ObservableList<Item> getObservableList() {
            return itemList;
        }


        public static Item addItemToList(String name, String value, String serialNumber) {
            Item cell = new Item(name, value, serialNumber);
            itemList.add(cell);
            return cell;
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

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < itemList.size(); j++) {
                    if (itemList.get(j).getItemName().contains(array[i]) || itemList.get(j).getItemSerialNumber().contains(array[i])) {
                        filteredInventory.add(itemList.get(j));
                    }
                }
            }

            return filteredInventory;
        }
    }
