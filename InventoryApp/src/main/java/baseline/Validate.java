/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */

package baseline;
import javafx.collections.ObservableList;

public class Validate {

public static boolean validateItemName(String nameToValidate) {
    //Check if new string name length is greater than 2 but less than 256
    //if so return true
    return false;
    }
public static boolean validateItemValue(String valueToValidate) {
    //parse the double value
    //check if the value is greater than 0
    //if so return true
    return false;
    }
public static boolean validateItemSerialNumber(ObservableList<Item> itemList, String serialNumberToValidate) {
    //check if the serial number is in the form 'A-XXX-XXX-XXX'; possibly use regex expression
    //loop through the entire observable list accessing each item's serial number
    //comparing it to the new serial number
    //if an item's serial number matches the serial number we want to evaluate then we return false
    return false;
    }
}
