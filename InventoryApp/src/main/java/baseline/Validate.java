/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */

package baseline;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class Validate {

public static Label validateItemName(String nameToValidate, Label errorLabel) {
    //Check if new string name length is greater than 2 but less than 256
    if (nameToValidate.length() > 256) {
        errorLabel.setText("Too many characters try again");
        return errorLabel;
    }else if(nameToValidate.length() < 2) {
        errorLabel.setText("Too few characters try again");
        return errorLabel;
    }

    //if so return true
    return errorLabel;
    }
public static Label validateItemValue(String valueToValidate, Label errorLabel) {
    Double valueConverted = Double.parseDouble(valueToValidate);

    if (valueConverted < 0) {
        errorLabel.setText("Item must have a value greater than or equal to 0 try again");
        return errorLabel;
    }
    //parse the double value
    //check if the value is greater than 0
    //if so return true
    return errorLabel;
    }
public static Label validateItemSerialNumber(ObservableList<Item> itemList, String serialNumberToValidate, Label errorLabel) {
    //check if the serial number is in the form 'A-XXX-XXX-XXX'; possibly use regex expression
    //loop through the entire observable list accessing each item's serial number

    ////[A-Za-z]-[A-ZaZ0-9]-[A-ZaZ0-9]-[A-ZaZ0-9]
    if (!serialNumberToValidate.matches("[A-Za-z]-[A-Za-z0-9]{3}-[A-Za-z0-9]{3}-[A-Za-z0-9]{3}")) {
        errorLabel.setText("Serial number not in correct format try again");
        return errorLabel;
    }
    for (int i = 0; i < itemList.size(); i++) {
        if (serialNumberToValidate.equals(itemList.get(i))) {
            errorLabel.setText("Serial number already exists try again");
            return errorLabel;
        }else {
            continue;
        }
    }
    //comparing it to the new serial number
    //if an item's serial number matches the serial number we want to evaluate then we return false
    return errorLabel;
    }
}
