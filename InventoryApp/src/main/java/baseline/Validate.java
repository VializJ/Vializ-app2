/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Javier Vializ
 */

package baseline;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

public class Validate {

public static String validateItemName(String nameToValidate) {
    //Check if new string name length is greater than 2 but less than 256
    if (nameToValidate.length() > 256) {
       return "Too many characters try again";
    }else if(nameToValidate.length() < 2) {
       return "Too few characters try again";
    }

    //if so return true
    return "";
    }
public static String validateItemValue(String valueToValidate) {
//    if (!valueToValidate.matches("\\d{2}.\\d{2}")) {
//        errorLabel.setText("Invalid item value format");
//        return errorLabel;
//    }
//
//    Double valueConverted = Double.parseDouble(valueToValidate);
//
//    if (valueConverted < 0) {
//        errorLabel.setText("Item must have a value greater than or equal to 0 try again");
//        return errorLabel;
//    }
    try {
        Double valueConverted = Double.parseDouble(valueToValidate);

        if (valueConverted < 0) {
            return "Item must have a value greater than or equal to 0 try again";
        }

        if (valueToValidate.matches("\\d{2}.\\d{2}") ||
                valueToValidate.matches("\\d{3}.\\d{2}") ||
                valueToValidate.matches("\\d{4}.\\d{2}") ||
                valueToValidate.matches("\\d{5}.\\d{2}") ||
                valueToValidate.matches("\\d{6}.\\d{2}") ||
                valueToValidate.matches("\\d{7}.\\d{2}") ||
                valueToValidate.matches("\\d{8}.\\d{2}") ||
                valueToValidate.matches("\\d{9}.\\d{2}")
        ) {
            return "";
        }else {
            return "Invalid item value format";
        }

    }catch(Exception e) {
        e.printStackTrace();
        return "Invalid item value format";
    }




    
    
    
    //parse the double value
    //check if the value is greater than 0
    //if so return true
}
public static String validateItemSerialNumber(ObservableList<Item> itemList, String serialNumberToValidate) {
    //check if the serial number is in the form 'A-XXX-XXX-XXX'; possibly use regex expression
    //loop through the entire observable list accessing each item's serial number

    ////[A-Za-z]-[A-ZaZ0-9]-[A-ZaZ0-9]-[A-ZaZ0-9]



//    if (!serialNumberToValidate.matches("[A-Za-z]-[A-Za-z0-9]{3}-[A-Za-z0-9]{3}-[A-Za-z0-9]{3}")) {
//        errorLabel.setText("Serial number not in correct format try again");
//        return errorLabel;
//    }
//    for (int i = 0; i < itemList.size(); i++) {
//        if (serialNumberToValidate.equals(itemList.get(i))) {
//            errorLabel.setText("Serial number already exists try again");
//            return errorLabel;
//        }else {
//            continue;
//        }
//    }


    if (!serialNumberToValidate.matches("[A-Za-z]-[A-Za-z0-9]{3}-[A-Za-z0-9]{3}-[A-Za-z0-9]{3}")) {
            return "Serial number not in correct format try again";
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
                System.out.println(serialNumberToValidate);
                return "Serial number already exists try again";
            }else {
                continue;
            }
        }





    //comparing it to the new serial number
    //if an item's serial number matches the serial number we want to evaluate then we return false
    return "";
    }
}
